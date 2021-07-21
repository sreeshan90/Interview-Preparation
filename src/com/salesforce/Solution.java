package com.salesforce;

import java.util.*;
import static java.util.stream.Collectors.toSet;

/**
 * author: Sreesha Nagaraj
 */
interface Command { // generic interface for a command
    Map<String, Object> execute(List<String> args);
}

class DependCmd implements Command {

    @Override
    public Map<String, Object> execute(List<String> input) {
        String dep = input.get(0);
        Map<String,Object> result = new LinkedHashMap<>(); // stores the results to print
        Component curr = Component.getInstance(dep);

        for (String strDependency : input.subList(1, input.size())) {
            Component dependency = Component.getInstance(strDependency);

            if (dependency.getDependencies().contains(curr)) {  // check for cyclic dep - ignore if its a case
                result.put(dependency.getName(),"depends on "+ curr.getName() +", ignoring command");
                continue;
            }

            curr.addDependency(dependency);
            dependency.addDependent(curr);
        }
        return result;
    }

}
class InstallCmd implements Command {

    @Override
    public Map<String, Object> execute(List<String> args) {
        Map<String, Object> result = new LinkedHashMap<>();
        for (String depName : args) {

            Component dep = Component.getInstance(depName);
            install(dep, result);
        }
        return result;
    }

    private Map<String, Object> install(Component current, Map<String, Object> result) {
        if (!current.isInstalled()) {
            current.setInstalled(true);


            for (Component dependency : current.getDependencies()) {
                if (!dependency.isInstalled()) {
                    install(dependency, result);
                }

            }
            result.put(current.getName(), "Installing");

        }
        else {
            result.put(current.getName(), "is already installed");

        }
        return result;
    }
}
class ListCmd implements Command {


    @Override
    public Map<String, Object> execute(List<String> args) {
        Map<String, Object> result = new LinkedHashMap<>();
        Component.getInstalled().forEach(m -> result.put(m.getName(),""));
        return result;
    }

}
class RemoveCmd implements Command {

    @Override
    public Map<String, Object> execute(List<String> args) {
        Component d = Component.getInstance(args.get(0));
        Map<String,Object> result = new LinkedHashMap<>();
        if(d != null)
            return remove(d, result);

        result.put(args.get(0),"is not installed");
        return result;
    }

    private Map<String, Object> remove(Component module, Map<String, Object> result) {

        Set<Component> installedDependents = module.getDependents().stream().filter(Component::isInstalled).collect(toSet());
        Set<Component> installedDependencies = module.getDependencies().stream().filter(Component::isInstalled).collect(toSet());

        if (!module.isInstalled()) {
            result.put(module.getName(), "is not installed");
            return result;
        }
        if (!installedDependents.isEmpty()) { // There are some modules who need this module, cannot be removed
            result.put(module.getName(), "is still needed");
            return result;
        }

        result.put(module.getName(), "Removing");
        module.setInstalled(false);

        if(!installedDependencies.isEmpty()) { // can be removed - check if there are any dependents who can be removed

            for (Component dependency : installedDependencies) {

               if (dependency.getDependents().stream().filter(Component::isInstalled).collect(toSet()).isEmpty()) {
                    result = remove(dependency, result);
               }
            }
        }

        return result;
    }
}

class Component {

    protected static Map<String, Component> dependencyMap = new HashMap<String, Component>();
    private String name;
    private Set<Component> dependents = new HashSet<Component>();
    private Set<Component> dependencies = new HashSet<Component>();

    private boolean installed;

    private Component(String name) {
        this.name = name;
    }

    public static Component getInstance(String name) {
        Component target = dependencyMap.get(name);
        if (target == null) {
            target = new Component(name);
            dependencyMap.put(name, target);
        }
        return target;
    }

    public String getName() {
        return name;
    }

    public boolean isInstalled() {
        return installed;
    }

    public void setInstalled(boolean installed) {
        this.installed = installed;
    }

    public Set<Component> getDependents() {
        return dependents;
    }

    public Set<Component> getDependencies() {
        return dependencies;
    }

    public boolean addDependency(Component d) {
        return dependencies.add(d);
    }

    public boolean addDependent(Component d) {
        return dependents.add(d);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()){
            return false;
        }

        Component comp = (Component) o;

        if ( !name.equals(comp.name) ){
            return false;
        }

        return true;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }


    public static Collection<Component> getAll() {
        return dependencyMap.values();
    }

    public static void clearAll() {
        dependencyMap.clear();
    }

    public static Set<Component> getInstalled() {
        Set<Component> installed = new HashSet<Component>();
        for (Component module : dependencyMap.values()) {
            if (module.isInstalled())
                installed.add(module);
        }
        return installed;
    }
}

public class Solution {
    /*
     * Complete the function below.
     */

    private static Map<String, Command> COMMAND_LIST = new HashMap<>();

    static {


        COMMAND_LIST.put("INSTALL", new InstallCmd());
        COMMAND_LIST.put("REMOVE", new RemoveCmd());
        COMMAND_LIST.put("LIST", new ListCmd());
        COMMAND_LIST.put("DEPEND", new DependCmd());
    }

    static void doIt(String[] input) {

        for (String line : input) {
            if (line.equals("END")) {
                System.out.println(line);
                break;

            }
            String[] arguments = line.split("[ ]+");
            Command cmd = COMMAND_LIST.get(arguments[0]);
            if (cmd == null) {
                throw new IllegalArgumentException("Unknown command " + line);
            }

            System.out.println(line);
            List<String> args = new LinkedList<String>(Arrays.asList(arguments));
            args.remove(0); // remove command
            Map<String, Object> success = cmd.execute(args);
            success.entrySet().stream().forEach(e -> {
                if (e.getValue().equals("Installing") || e.getValue().equals("Removing")) {
                    System.out.println("\t" +  e.getValue() + " " + e.getKey());
                }
                else {
                    System.out.println("\t" + e.getKey() + " " + e.getValue());
                }

            });
        }
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int _input_size = 0;
        _input_size = Integer.parseInt(in.nextLine().trim());
        String[] _input = new String[_input_size];
        String _input_item;
        for(int _input_i = 0; _input_i < _input_size; _input_i++) {
            try {
                _input_item = in.nextLine();
            } catch (Exception e) {
                _input_item = null;
            }
            _input[_input_i] = _input_item;
        }

        doIt(_input);

    }
}
