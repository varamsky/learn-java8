SAP Labs
Developer - Java, TypeScript, Node JS or JavaScript

1. Interview started with general introduction.
2. Project discussion from a Business perspective. Talked about FrontDoorCorp, pickup and delivery service application.
3. Why use Spring Boot? What benefits it has as compared to others like NodeJS
4. Which component of your (pickup and delivery)project architecture will be responsible to manage large amount of load like millions of requests and how?
5. OOPS in Java? Give examples from current project.
6. Problem statment:
   - We have a number of organisations in a hierarchical manner and they are interlinked. Need to find out if there is a cycle.
     - Couldn't answer this one. This is a cycle detection problem in graphs. He wanted me to figure out which DS to use and how to structure it.
     - I couldn't make sense of it that it would boil down to a graph situation.
     - Every node can have n-number of associations and there is no root as such.
     - This could be solved if treated the input data as graph adjacency matrix.


Type of Node

Type of Cycle - node1, node2

List<Cycle> findCycle(List<Node> nodes){
if(nodes is not empty){
get a node
put its children in a queue
pick items from queue

    }
}

node 1 = n number of associations(directed), 1 parent

node2 =
node1 = node 2, node 3
node3 = node 4
node4 = node1

        node 1

node 2          node 3

                node 4

cycle in a tree

graph

TreeNode {
int value;
left
right
parent
}

recursion
hashset

node 1 = parent null

input = TreeNode root
output = [TreeNode]

Step 1 = 