# 1st Interview - 25/02/2025

1. What is the benefit of using Spring when building a microservice application?

2. What is the use of actuators in Spring?
- Health Monitoring
- Metrics Monitoring
- Dynamically change log levels without restarting the app
- Check database connection health and query performance

3. What is serialization in Java and its uses?
- Real life uses -> Caching, Storing user sessions

4. HashMap vs LinkedHashMap?
- No guarantee or ordering in HashMap whereas LinkedHashMap guarantees ordering.

5. Explain about Kafka consumer and producer mechanism?

6. What is a Balanced Binary Tree?

7. Scenario
You are given the following database schema for an e-commerce platform:
Tables
Customers
customer_id (int, primary key)
customer_name (varchar)
registration_date (date)
Orders
order_id (int, primary key)
customer_id (int, foreign key references Customers(customer_id))
order_date (date)
order_total (decimal)
OrderItems
order_item_id (int, primary key)
order_id (int, foreign key references Orders(order_id))
product_id (int)
quantity (int)
price (decimal)
Products
product_id (int, primary key)
product_name (varchar)
category (varchar)
Question
Write a SQL query to find the top 5 customers who have spent the most money on products in the "Electronics" category in the year 2023. The query should return the customer_id, customer_name, and the total amount spent.


Answer - 


SELECT c.customer_id, c.customer_name, SUM(oi.price * oi.quantity) as total_amount_spent
from Customers c JOIN Orders o ON c.customer_id = o.customer_id
JOIN OrderItems oi ON o.order_id = oi.order_id
JOIN Products p ON p.product_id = oi.product_id
WHERE o.order_date = 2023 AND p.category = 'Electronics'
GROUP BY customer_id, customer_name
ORDER BY total_amount_spent DESC
LIMIT 5;


8. Scenario
You are given a binary tree where each node contains an integer value. You need to find the maximum sum of non-adjacent nodes. Two nodes are considered adjacent if one is the parent of the other. Implement a solution using dynamic programming and Java 8 features.
Question
Write a Java method that returns the maximum sum of non-adjacent nodes in a binary tree. The method should use dynamic programming to store intermediate results and Java 8 features like streams and lambda expressions to enhance readability and efficiency.
Requirements
Implement a class TreeNode to represent a node in the binary tree.
Implement a method maxSumNonAdjacent(TreeNode root) that returns the maximum sum of non-adjacent nodes.
Use dynamic programming to store results for subproblems.
Use Java 8 features such as streams and lambda expressions in your implementation.

Example - 
          3        
    2              5
       3                    1
Any number of nodes can be used to have the max sum
DFS

3 + 






Answer -









class TreeNode {
	int val;
	TreeNode left, right;

	TreeNode(int val){
		this.val = val;
		this.left = null;
		this.right = null;
	}
}



public class MaxSumNonAdjacent {

// Write method to calculate the maximum sum of non-adjacent nodes
    public int maxSumNonAdjacent(TreeNode root) {
	int[] result = dfs(root);
	return Math.max(result[0], result[1]);
}

	public int[] dfs(TreeNode node){
		if(node == null) return new int[]{0, 0};

		int[] left = dfs(node.left);
		int[] right = dfs(node.right);
	
		// include then it is non adjacent
		int include = node.val + left[1] + right[1];
		// exclude then it is adjacent
		int exclude = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

		return new int[](include, exclude);
	}



public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(1);

        MaxSumNonAdjacent solver = new MaxSumNonAdjacent();
        System.out.println("Maximum sum of non-adjacent nodes: " + solver.maxSumNonAdjacent(root));
    }


}


9. If the user is seeing a website is slow, what all could be the issue and how will you fix them?

Database -> indexing -> short query fetch time
Replicas 
Caching -> redis 
Backend -> 
Frontend -> imag(reduce image size), CDN

# 2nd Interview - 04/03/2025

They work on communications between different upstreams and downstreams services.
Data transformation(Transformation of one JSON structure to another)

1. How do you do Service to service communication in spring?
   - REST API (WebClient) - Synchronous
   - Asynchronous with redis or kafka
   - Service discovery is also service to service communication
2. What is synchronous vs asynchronous communication?
   - No blocking in asynchronous
   - Blocking in synchronous - code will wait there for result.
3. Define kafka working and How is kafka asynchronous?
4. Operational level challenges with containerisation and kubernestes?
   - Security
   - Testing
   - Storage and consistency
   - Resource Management & Scaling Issues
   - Networking & Service Discovery
   - Logging & Monitoring Complexity
5. What all do we need to handle in data transformation services?
   - Format Conversion
   - Data Cleansing & Standardization
   - Schema Mapping & Transformation
   - Filtering & Masking Sensitive Data
   - Error Handling & Data Validation
7. What Cache invalidation strategies to use in data transformation services?
8. How and where to look for bottlenecks in such a system?
9. how to MANAGE large number of REST apis in production?
   - API Versioning Strategy
   - API Documentation & Discovery
   - Testing Standards(like common HTTP status codes 404 and so on..) and Error Handling
   - API Rate Limiting & Throttling
   - API Security best practices
   - API Monitoring & Logging
   - API Scaling & Load Balancing
11. Create a Spring Boot application

1. Consumes a simple JSON message representing a customer change from an upstream.
2. Transforms it to a different JSON format for a downstream system
3. Handles potential validation errors
4. Logs the transformation process


Input: 

`{
  "id": "0012500001ABC123",
  "type": "Customer",
  "attributes": {
    "Name": "Acme Corporation",
    "Industry": "Technology",
    "BillingCity": "San Francisco",
    "BillingCountry": "USA",
    "AnnualRevenue": 10000000,
    "IsActive": true,
    "LastModifiedDate": "2023-03-15T14:30:22Z"
  }
}`
Output:

`{
  "customerId": "0012500001ABC123",
  "customerName": "Acme Corporation",
  "details": {
    "sector": "Technology",
    "location": {
      "city": "San Francisco",
      "country": "USA"
    },
    "financials": {
      "revenue": 10000000
    },
    "status": "ACTIVE",
    "lastUpdated": "2023-03-15T14:30:22Z"
  }
}`

- ANSWER =
- Transform JSON structure with MapStruct somewaht like this
- @Mapper
public interface UserMapper {
    
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(source = "name", target = "full_name")
    @Mapping(source = "email", target = "email_address")
    UserDTO toUserDTO(User user);

}
- Do validations like this

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    
    @NotBlank(message = "Name is required")
    private String name;

    @Email(message = "Invalid email format")
    @NotBlank(message = "Email is required")
    private String email;

    @Min(value = 18, message = "Must be at least 18")
    private int age;
}
