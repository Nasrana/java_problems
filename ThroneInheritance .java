class ThroneInheritance {

    // Maps each person to the list of their children, in birth order
    private final Map<String, List<String>> family = new HashMap<>();
    // Keeps track of who has died (without removing them from the tree)
    private final Set<String> dead = new HashSet<>();
    // Remember the king's name so we always know where to start the DFS
    private final String king;

    public ThroneInheritance(String kingName) {
        king = kingName;
        family.put(kingName, new ArrayList<>());
    }

    public void birth(String parentName, String childName) {
        // Give the new child their own (initially empty) child list
        family.put(childName, new ArrayList<>());
        // Add them to the end of their parent's children -> preserves birth order
        family.get(parentName).add(childName);
    }

    public void death(String name) {
        // We don't remove them from the tree, just mark them as dead.
        // This matters because their descendants still inherit through them.
        dead.add(name);
    }

    public List<String> getInheritanceOrder() {
        List<String> order = new ArrayList<>();
        // Rebuild the whole order from scratch with a pre-order DFS,
        // starting from the king, skipping anyone who's dead.
        dfs(king, order);
        return order;
    }

    private void dfs(String person, List<String> order) {
        // Add this person first (pre-order), unless they're dead
        if (!dead.contains(person)) {
            order.add(person);
        }
        // Then visit each child, oldest to youngest, same rule applies
        for (String child : family.get(person)) {
            dfs(child, order);
        }
    }
}