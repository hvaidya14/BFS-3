// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) {
            return null;
        }
        Map<Node, Node> m = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        Node node1 = new Node(node.val);
        m.put(node, node1);
        q.add(node);
        while(!q.isEmpty()) {
            Node existing = q.poll();
            List<Node> neighbors = existing.neighbors;
            for (Node neighbor:neighbors) {
                if (!m.containsKey(neighbor)){
                    Node copynode = new Node(neighbor.val);
                    m.put(neighbor, copynode);
                    m.get(existing).neighbors.add(copynode);
                    q.add(neighbor);
                } else {
                    Node copiednode = m.get(neighbor);
                    m.get(existing).neighbors.add(copiednode);
                }
            }
        }
        return node1;
    }
}
