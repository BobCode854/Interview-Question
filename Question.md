Java 8 
==========
--> Functional Interface - done
--> Know about all 4 basic functional interface provided by Java . - done
--> How to create custom Functional Interface - done
--> jwt vs oauth2
--> SSO - OIDC 
--> Coding Questions : 
======================
   String based , String[] based , primitive int [] based , List based , Map based , Custom Employee object based , flatmap() based .
   
--> executor sevice and thread pool - done
--> Locking mechanism - done
--> fork join
--> lazy evaluation in stream - done
--> stream().stream() - done
--> checked exception in stream - done
--> parallel stream  when should we not use
--> Identity hashmap - done
spy vs mock - done

parametrised text in Junit - done
Testing pyramid
 
 Java 11 some of the  important features
 ============================
    1) New utility methods in String class - 
	              isBlank() , 
				  strip(),stripLeading(),stripTrailing() - strip method remove whitespaces. strip() is “Unicode-aware” evolution of trim()
				  repeat() , 
	2) Local-Variable Syntax for Lambda Parameters :  (var v1 , var v2)->v1+v2;
	3) Reading/Writing Strings to and from the Files
	            readString()
				writeString()
				
				
Java 17 new Features
====================
   Java 17 has been evolved providing major enhancement on
     
	
		  1)  Sealed classes :  Sealed classes in Java 17 allow developers to control which classes can extend a given class.
				  
				   --) sealed keyword restricts inheritance to only Car 
                   --)  permits specifies which classes can extend class.
				   --)  public sealed class Vehicle permits Car, Bike 
				   
		2) Pattern Matching for switch (Preview) – Cleaner and more expressive switch
		    ========================================================
			  --) Prior to Java 17, switch worked only with primitive types, String, and enums
			  --) If we needed to handle different object types, we had to rely on if-else with instanceof and explicit type casting.
			  
			  
			      ================================
				 
				 older approach
				   *******************
				    if (obj instanceof Integer) {
							Integer i = (Integer) obj; // Explicit casting needed
							System.out.println("Integer: " + (i * 2));
						} else if (obj instanceof String) {
							String s = (String) obj;
							System.out.println("String: " + s.toUpperCase());
						} 
				 newer approach
				 ****************
				  switch (obj) {
						case Integer i -> System.out.println("Integer: " + (i * 2));
						case String s -> System.out.println("String: " + s.toUpperCase());
						case Double d -> System.out.println("Double: " + (d + 10.5));
						case null -> System.out.println("Null value provided!");
						default -> System.out.println("Unknown type!");
					}
				   
           3)  Records (Finalized from Java 16) – Concise data classes.
		        ================================================
		    --) Before records, we had to manually write constructors, getters, toString(), equals(), and hashCode(), making the code verbose .
			--) Too much boilerplate code for a simple data class.
			--)  Manually maintaining equals(), hashCode(), toString() is error-prone.
			--)  Records are immutable data classes, They simplify the creation of data-carrying classes by automatically providing:
					✔ Immutable fields (no setters).
					✔ Generated constructor, equals(), hashCode(), and toString().
		  
		                  public record Employee(String name, int age) {}
						  
		  --) You can still add custom methods in records if needed.

        4)   Text Blocks – Multi-line string literals (""")
		      =================================================
			  --) Before Text Blocks, defining multi-line strings required manual concatenation (+), escape sequences (\n), and indentation issues.
			  --) It provide a cleaner syntax for multi-line strings using triple quotes (""").
			  
							 String json = """
								{
								  "name": "Alice",
								  "age": 25,
								  "city": "New York"
								}
								""";
								
	  5) Instanceof Pattern Matching (Finalized from Java 16) – Cleaner type checks.
	       ==========================================================
		   --) Before Java 16, using instanceof required explicit type casting after checking an object's type.
		   
					  Object obj = "Hello, Java 17!";

						if (obj instanceof String) {
							String str = (String) obj;  // Manual casting required   // older approach
							System.out.println(str.toUpperCase());
						}
						
						// newer approach
						
						if (obj instanceof String str) {  // Direct variable declaration
							System.out.println(str.toUpperCase());
						}
						
						
================
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
new passcode : 173008


============
SessionId vs JWT
Stateless meaning 
How stateless is related with sessionId and JWT
Stateless behavior with formLogin and postman
======================================================================================
Final 
======================================================================================
1) How can we performance tune the gc ( what configuration we can do)
2)  What are the loader of class
3)  Implment redis cache
4)  SoftHashmap vs weakhashmap
5) fork join
6) 2 phase commit vs saga design
7) 3 phase commit vs saga design
8) consumer , supplier , biconsumer
9)  how to create your own annotation.
10) print even odd from 2 thread
11)  what are the application standard you will handle to remove memory leak or outofmemory error in java
12)  create 2 thread where one thread will print even and other will print odd.
        ============================================================================
		 --) Tune Heap Size : Use -Xms (initial) and -Xmx (maximum heap size) to match expected memory requirements.
		 
		 --) Code-Level Memory Leak Prevention
		           --) Remove Unused Object References :   
				                --) Drop references when no longer needed.
								--) Avoid retaining large objects in static fields or long-lived caches without limits.
								
				  --) Use Efficient Data Structures
				               --) Replace heavy data structures with more efficient ones.
							   --) Avoid huge arrays/lists that grow without bounds.
							   --) Use streams/batch processing instead of loading everything in memory at once.
              
	   --) Close resources properly
	                      --) Always close I/O streams, DB connections, sockets, etc., to free native memory.
						  --)  Use try-with-resources introduced in Java 7 — best practice to avoid leaks even after exceptions.
						  
	  --) Use Smart References
	                --) Use WeakReference / WeakHashMap for caches or temporary objects so GC can collect them when needed.
					
					
	--) Profiling & Monitoring (Continuous)
	                  --) Use memory profiling tools :  VisualVM, Eclipse Memory Analyzer (MAT), Java Flight Recorder, JProfiler, etc., let you inspect heap usage and find leaks early
					  
	--) Coding Standards to Avoid Common Leak Patterns
	                        ✔ Avoid unnecessary object creation
							✔ Use immutable objects where possible
							✔ Deregister event listeners/callbacks when no longer used
							✔ Avoid keeping references to objects longer than needed (especially in GUI apps, thread pools, listeners).
							
							
							
Ques ) Suppose we have make a class A which is singleton and another class B is of prototype , now we have a singelton class reference in prototype class  and we are creating 5 objects of prototype class , what will happen and what changes is required to maintain the singleton principal of class A ? 

 Solution
 ============
     ✔ Class A remains a single instance — Spring will create only one object of A and reuse it everywhere because it’s a singleton bean. All B instances will reference that same single instance of A.
   ✔ Class B will be created 5 times — each time you request bean B from the container, Spring creates a new instance of B because its scope is prototype.
   
   ➡ So you end up with:

			B1.a → A@123
			B2.a → A@123
			B3.a → A@123
			B4.a → A@123
			B5.a → A@123


      👉 Each prototype B has its own object, but the reference to A is always the same because A is a singleton.
     💡 This already preserves singleton principle — A stays a single instance. That’s correct, and no change is required just to keep A singleton.
	 
	 
	 🔍 Common Misunderstanding (Prototype inside Singleton)
         
		  The real tricky case is singleton containing prototype, not prototype containing singleton:
		  
		  
		  @Component
		 @Scope("singleton")
			public class A {
			   @Autowired
			   private B b;  // prototype inside a singleton
			}

			In this case:
			
			Spring will create one instance of A
			Only one instance of B gets injected into A — even though B is prototype — because injection happens once at creation time of A. 
			Home
			So although B is defined as prototype, A ends up reusing the same B instance — prototype behavior is lost. 
			
			
			✅ How to Preserve True Prototype Behavior within Singleton
                    If A (singleton) needs new B instance every time, you cannot directly inject B — Spring only resolves prototype injection once by default.

				✔ Solution 1 — Use ObjectProvider or ObjectFactory
				************************************************************
				@Component
				@Scope("singleton")
				public class A {

					@Autowired
					private ObjectProvider<B> bProvider;

					public void someMethod() {
						B b1 = bProvider.getObject();  // new prototype
						B b2 = bProvider.getObject();  // a different prototype
					}
				}
				
				✔ Solution 2 — Use @Lookup
				************************************
					@Component
					@Scope("singleton")
					public abstract class A {

						public void process() {
							B b = getB();  // every call gives new B
						}

						@Lookup
						protected abstract B getB();
					}
					
| Relationship                                                                              | What happens                                                                    | Required to retain true prototype behavior?  |
| -------------------------------------------------- -------------------- | -------------------------------------------------------------------| ---------------------------------------------------------- |
| **Prototype B references Singleton A**                            | ✔ A remains singleton for all B instances                   | ❌ No changes needed — already singleton      |
| **Singleton A references Prototype B (normal DI)**     | ✖ Only one B is injected — prototype behavior lost | ✔ Use `Provider`, `ObjectFactory`, `@Lookup` |



Spring security - Selenium / Javatechie
Docker - Javatechie

Interview Questions
========================
BE Side
===========
vowels in a pagagraphg  . I am a Engineer.    
String regex = [aeiouAEIOU]
Arrays.stream(str.split("")).filter(character-> regex.contains(character)).forEach(System.out::println);

3) Design a low-latency, fault-tolerant distributed system that can handle millions of requests per second.
4) Implement a concurrent producer-consumer system with CompletableFuture . 
5) How we can write joins in Spring boot

         -- we can use @Query annotation to write join for inner,left, right
		 --  Use JPQL with JOIN in @Query methods to fetch related data.
		 --Optionally use native SQL for complex or non-JPA queries.
		 -- JOIN just selects data from both.
		 -- JOIN FETCH  forces JPA to retrieve related entities eagerly in one query (solves N+1 problem).
		 
		 -- @EntityGraph also we can use
		            -- @EntityGraph(attributePaths = {"books"})
                         List<Author> findAll();	 
					-- No JPQL string needed .  JPA will internally create the appropriate joins for you. Great for optimizing related fetches without writing joins manually
					
		 -- We can use @ManyToOne or @OneToMany
		 -- We can use CriteriaBuilder , create CriteriaQuery ( Used also for dynamic filters)
		              -- Crtieria Builder object is fetched from EntityManager
					  -- CrtieriaQuery object is created from criteriaBuilder object
					  -- We can root object from criteriaQuery
					  -- we create join object from root on condition
					  --  then we write query
					  --  query.select(root).where(cb.equal(authorJoin.get("name"),"Karan");

6) Call Stored Procedure through spring boot 
         -- @Procedure(procedureName = "procedureName")
		 --  SimpleJdbcCall interface we can use
		 -- StoredProcedureQuery
		 
7) Messaging Kafka how it works ( Acknowledgment problem)
      =================================================
	    BASIC MESSAGE FLOW
		*****************************
		
	   -- Producer sends a message to a Kafka topic partition.
	   -- The Kafka broker receives the message and (depending on config) stores it on disk and/or replicates it to other brokers.
	   -- The consumer reads messages from the partition and processes them.
	   -- Consumers acknowledge consumption by committing offsets — telling Kafka “I’ve handled this up to this point.” 
	   
	   Kafka is designed as a distributed commit log, not a traditional queue — so acknowledgments are about persistence and 
	   processing guarantees rather than simple message deletion
	   
	   📌 2. Producer Acknowledgments (acks)
			************************************************
            -- The producer acks setting controls how many brokers must confirm receipt before the producer treats the send as successful. This directly affects    durability and reliability:

           🔹 acks=0

             The producer doesn’t wait for any broker acknowledgment.
             Fastest throughput, but message can be lost without the producer knowing.

                    Suitable for non-critical logs/metrics. 
					🔹 acks=1
					-- Producer waits for confirmation from the leader of the partition.
					-- Leader confirms the message is written to its local log.
					-- If the leader crashes before replication, data can still be lost. 

                 🔹 acks=all (or acks=-1)
						-- Producer waits for all in-sync replicas (ISRs) to acknowledge.
						-- Provides strong durability — the message won’t be lost even if the leader fails after ack.
						-- Slightly higher latency. 

           
		   👉 The choice of acks balances speed vs durability. Persistent or financial data typically uses acks=all, while high-speed logs might use acks=0.
		   
		   📈 3. Delivery Semantics (Guarantees)

							Kafka defines three delivery semantics:
									Guarantee                   	Meaning
									At most once	            Message may be lost, but never redelivered.
									At least once	            Message will be delivered, but possibly more than once (duplicates).
									Exactly once	                Message processed exactly once end-to-end (hardest to achieve).
	   
	   
8) Multithreading basic problem - done
9) Devops (git versioning , api versioning)
we want to use war vs jar  - done
10) i am creating spring boot app , I have to write query and have to protect against CQRS , code it
11) Redis cache
12) N+1 problem  
13) parallel stream worst than stream, when - done
14) reverse a linkedlist code
15) Interface segregation principal and Liskov's principal code - done
--> executor sevice and thread pool - done
--> Locking mechanism - done
--> fork join
--> lazy evaluation in stream - done
--> stream().stream() - done
--> checked exception in stream - done
--> parallel stream  when should we not use - done
--> Identity hashmap - done
-- what kind of circuaar dependency cannot be resolved
--interceptor vs filter
--save vs persist method 
-- where to store If we have multiple  usersname and password 
-- priority queue - done
--blocking queue - done
-- Application Monitoring tool - Java, Spring - done
-- jwt vs oauth2
--> SSO - OIDC 
============
        List<String> stringList = List.of("Hi","Hello","Hola");
		List<String> stringList1 = List.of("Hey","Hazle","Hope");
		List<String> mergedList = Stream.concat(stringList1.stream(),stringList.stream()).toList();
		System.out.println(mergedList); - done

		List<List<String>> listofString
				= Arrays.asList(stringList1,stringList);
		Set<String> finalList=  listofString
				                 .stream().flatMap(List::stream).collect(Collectors.toSet());
		System.out.println(mergedList); - done

		List<String> objectList = List.of("Hi","Hello","Hola","1","111","11karan");
		objectList.stream()
				.filter(s->s.chars().allMatch(Character::isDigit))
				.forEach(System.out::println);
		List<String> numericOnly = objectList.stream()
				.filter(s -> s.matches("\\d+"))   // only digits, one or more
				.toList();
================

--List list1 = ("Java", "8"); List list2 =("lets", "get", "strated"); // merge this 2 list.
-- List list =   ("Java", "8","lets", "get", "strated","22","22Karan"); // check and filter only those string which contains only number

-- spring.properties and spring.yml is there which properties loads
          : when you use both YML and properties … first application.yml(higher precedence) will be loaded, later application.properties will be loaded … if same keys exist, properties value wins.




  onetomany vs manytoone - dependent side
  serialisation - done
How dockerise microservice app connect each other

Optional.of vs Optional.ofNullable
eviction in cache
LRU implementation
Create complete react to backend app
github workflow
Security with Keycloak , How Security being implemented , How keycloak verifies and authenticate the resource.
How Redis cache implemented 
MultiFactor Authentication
what are the concurrent feature of java - done
Parent ref child object question(static method , final method , normal method) - done
what are the migration problem happen with spring boot 3.0 + verison
What is doubly locked and reenterant lock .  - done
-- If I change application.properties to some other name like karan.properties then how to make spring know about this

UI Side
===========
1)  We  have 50 form field , while filling 30 field , application crashed , how to preserve this data.
React
  =======
    React Virtual DOM  - done
	 Reconcillation and diffing algorithm - done
	 Class component vs functional component - done
	  Component to compenent data transfer - done
	  React memo(memoization) and callback -done
	  context api and props drilling - done
	  Data transfer steps through redux - done
	  Security and Interceptors - done
	  Performance Optimization-done
	   Higher-Order Components,  - done
	   Pure Component and Impure Component - done
	   Controlled & Uncontrolled Components - done
	   Event Bubbling - done
	   Data from backend - done
	   CICD/UI Deployment - done
	   custom hooks
	   Redux flow for sending and fetching data
	   calling multiple api parallely(promise.all)
	   Redux toolkit vs redux
	   Dockerise Ui app and use of Kubernetes in that
	   event loop 
	this keyword
	   Thread dump : Thread deadlock

	Hooks - useEffect , useState, useCallback , useContext , useMemo , useRef , useReducer
custom hook
spread operator
api call
promise
redux flow
statemanagement 
redux vs context
button to increase counter
memoization
HOC
interceptors 
security
lazy loading
loading 1 million data
aynch call handle
Dockerise
Unit test
packaging - webpack
====
js
=============
closure


	   

AWS
====
lambda , serverless , SQS
dynamo db 

Devops
-======
blue green deployment
System Design
=====================
1) Roll base access managment .(RBAC ) System design (BE schema , UI handling)
2) Notification Service( No code change , Ui se dynamically select karke ,send notification directly)
3) E-commerce purchase 2 person shopping , and in db one product is there.
4)  Rate Limiter
s3 storage connectivuty
 
 
 completableFuture vs Future
 ExecutorService
 parallelStream vs sequentialStream
 Concurrent features in java
 
Kafka
=========
what are the different strategies of data fetching .(atleast,atmost) --many times asked
How to configure your kafka If you want to deploy to cloud
How to integrate in code if kafka deployed in cloud.,same with s3
You have an application need to autoscale, what changes in code is required
Code for kafka producer
Code for kafka consumer
kaka principal
acks,all,none in kafka consumer.
 If any of consumer is taking time to proceed and if we have type acks , how to handle, 
Auto commit , manual commit - Suppose kafka consumer get failed , how it should know that once consumer will up , it should read from there.
Suppose we have 4-5 partition in a topic and we are sending data , how it will be decided on which partition the data went. 
Also Suppose each partition accepts the data and now while consuming how consumer will know from which partition I need to accept the data.
How Kafka used in Cloud or aws env.

If we have 2 producer instance and 3 consumer instance how many minimum topics or parition will be there for safe operation.
can we save the data to db without opening transaction.
DS
=====
Longest common prefix
3 Sum
2 array -arrival and departure , find how many platform required.
Copy paste mechanism , which data structure involved
  trapping rain water  - asked many times
  
  Roman to number , number to roman
  
  1) Sorting (optimistic)
2) 2 sum
3) 90 degree rotation , matrix
4) subArray 0 sum
5) non repeating
6) LinkedList reverse and merge


AWS
===========
How to secure EC2 instance - (inbound , outbound rules set)(encryption , decryption key)
S3 client se connect - file send to s3 - file fetch from s3.
Serveless se connectivity : , configure serverless

================
Cache Mechanism


============================
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

==========================
In my project 
there are 5 microservice - User , Certification , Family, Vehicle, Discipline 

Also we have 4 env --> dev then test , acc , prod

I want to understand Jenkins job its phases , its lifecycle , code and proper explanation step by step 
Also How dockerise image will be created and deployed in kubernetes pods 

I want to understand role of each  jenkins , docker and kubernetes

cursor -postgres
ACID complaint postgres
server component react
export 
which react bundler is used for bundling
Alternate to git
api gateway type
proxy server - 




System Design
==============================
One machine and High RAM size + High memory  = Vertical scaling
multiple machine = Horizontal scaling

Horizontal scaling is Resilient : Means If one machine fails request is redirected to other machine and handles the request
Vertical Scaling :  It is having single point of failure , If one machine fails there is nothing such with which we can handle request.

Vertical scaling do InterProcess communication , because there is no other machine , hence it is fast.
Horizontal scaling , it is a network call and is slow compared to Vertical.

Data inconsistency is one of the real measure in Horizontal scaling while In vertical scaling it is having single memory so it is consistent.

In Horizontal scaling , it scales well when user increases , but not the same applied on Vertical scaling.


** Consistent Hashing


-- Monolithic can also be scale up horizontally and can have connected to multiple db.
-- If a team is small or cohesive go with monolith architecture with horizontal scaling the application.
-- Monolith is faster than microservice because network calls are not associated.
-- Single point of failure : If any server will fails , its very high chances its instances will be collapsed.
-- Stack overflow is developed on monolith architecture.


SQL
==================
1) Find name , prevoius year max sal , current year max sal from employee table
2) Find department wise top 3 highest salary 
	
DS
==========
longest common prefix
Roman to Integer
Java
======
Sort hashmap by value

Others
=========
Grant type in Oauth2
What is webpack
Redux flow in sending data - login page , to click the navigation link to send data to other component steps
Bean life cycle
TDD
CICD with git
spring boot application deployed on lambda
How to implement security with oauth2 
eviction in cache
LRU
Create complete react to backend app
github workflow
How can we create composite key in spring boot JPA
If primary cache is Hibernate why secondary cache
security on producing consuming data
deadlock in rehashing
How do we scale the consumer 
consumer offset
How to we scale the producer
promise.all
List<String> stringList = ["Volvo 10","Honda 5","10 Volkswagon"]

     Map<String,Integer> carToCountMap = new HashMap<>();


Spring Security
============
--> In Spring boot app , when we create the controller by default behind the scene Servlet will be created for the controller
--> And We have a dispatcher servlet which takes the endpoint request from client or UI and redirect it to correct Controller class.
--> But in Spring security instead of dispatcher servlet , we will have SecurityFilter  which intercept and then redirect .
--> These security filters do validation to the request . 
--> whether this is a valid request , or coming to valid client .
--> Some filters are like , provide login page , If it is rest related app then check http basics or If the data provided as part of page then match username pass.
--> The best part is we need not to define these things , spring automatically provide these things .


Java
=======
1) Lambda related question
2) flatmap operation - done
3) parallel stream - done
4) stream().stream() - done
5) ReentrantLock - done
6) What is deadlock situation how to handle it. - done
7) How to handle concurrency in java - done
8) Performance Tuning technique - done
9) Performance major tools - done
10) If the memory is full , how to handle this situation - done
11) Java is pass by value or reference explain
12) Composition vs Aggregation vs Association? - done
13) Can private method or static methods be overridden in Java? - done
14) Can Abstract class have main method? - done
15) What is Serialisation and Deserialisation? - done
16) Use of transient keyword - done
17) Is it possible to serialise a class if its super class is not serialisable ?Can the class be still serialised and deserialised? - done
18) Explain the difference between deep copy and shallow copy in Java, and provide examples of scenarios where each would be appropriate. - done
19)When Finally block doesn’t get executed?  - done
20)  Can subclass throw higher checked exception than base class?  - done
21) Why enum - done
22) How does Garbage collection in Java works? - done
23) ArrayList vs vector - done
24) ArrayList vs linkedList - done
25) Fail Safe vs Fail Fast Iterators - done
26) Internal working of HashMap ? try some coding with Employee object. - done
27) Is it Mandatory to have key immutable in HashMap? - done
28) What is blocking Queue?
29) create thread with both extend and implements  - done
30) yield() , sleep() , join()   -- done
31) I have 2 threads running , one for odd and one for even , I want 1 even to print then odd , what to does - done
32) wait vs sleep - done
33) why is join() method used? - done
34) Can we Override start() method in Thread? - done
35) Can we Override run() method in Thread? - done
36) What is IllegalThreadStateException
37) Why do we use ThreadPool - done
38) What is Race Condition - done
39) What is Synchronisation?Types of Synchronisation? - done
40) Object Level Locking vs Class Level Locking? - done
41) If there is 2 synchronised methods m1 and m2 in a class, can 2 different threads t1 and t2 call different methods(m1,m2) respectively on same object of class c at same time ? - done
42) If a class has a synchronised method and non synchronised method, can multiple threads execute non synchronised methods? - done
43) Can 2 threads call 2 different static synchronised methods of same class? - done
44) Does static synchronised methods block a non synchronised methods?
45) Can Constructors be synchronised?
46) What is Inter thread communication?Explain wait(),notify() and notifyall()? - done
47)  Which class does wait(),notify() and notifyall() method belong - done
48) Producer Consumer Problem in Java? - done
49) Volatile vs Synchronised?
50) What are Atomic variables? - done
51)  runnable vs callable  ? when to call which - done
52)  Future vs completable future with example code - done
53)  Use of Done() , IsCancelled() and Cancel() method of Future Object? - done
54)  What is ReEntrant lock? - done
55)  What is executor service ? how it is different from normal thread creation ? How many threads at a time we can create with this ? How method calls and thread executed in executor service ? explain each and every thing with example code . - done
56) Different types of ThreadExecutor Services? - done
57) Explain how FixedThreadPool executor works? - done
58) What is Functional Interface? why do we need it?
59)  Write code for each predefined functional interface
60)  Solid principal - done
61) Difference between ClassNotFound vs NoClassDefError - done
62) What is Singleton Design pattern?Explain ThreadSafe Singleton and Bill Pugh Singleton ?
63) Java 17 new features
64) Describe the principles of multithreading in Java and discuss how you would implement thread safety in a concurrent application. - done
65) What are lambda expressions in Java 8, and how do they improve code readability and conciseness? Provide examples of lambda expressions in action.
66) what is functional programming in java , how it is different from porevious java version.
67) Discuss the pros and cons of using Java serialization for object persistence and provide alternatives for serializing Java objects.
68) Explain the principles of design patterns in Java, including creational, structural, and behavioral patterns, and provide examples of each.
69) Person p = new Person("Karan") && Person p1 = new Person("Karan") p.equals(p1) - done
70) What is Garbage Collection in Java? How does it work?  - done


Java 8 coding
==============
Array  - primitive data sorting , nonPrimitive Sorting , reverse  each character, reverse the array of string ,  duplicates number, duplicate string
List - Integer sorting, long sorting , string sorting , duplicates , Object sorting
Map - sort based on key , based on value , Object sorting(based on price , name) 
String  - reverse the name ,
Number : findPrime , fibonacci , pallindrome ,
Optional.ofNullable vs Optional.of difference with code.
To print the count of each character in a String
 Print odd and Even list
 Print odd , Even sum
 Convert list to map
 Print Employee salary in Ascending order
 Find nth highest salary of employee
    Flatmap related questions
   
   1) Flatten a List of Lists of Integers into a single List of Integers
         List<List<Integer>> listOfLists = Arrays.asList(Arrays.asList(1, 2, 3), Arrays.asList(4, 5),Arrays.asList(6, 7, 8, 9));
		 
	2)  Square each number in the nested lists and flatten the result
	3) Given a List of Strings, flatten them into a list of Characters 
	                 Input: ["hello", "world"] Output: [h, e, l, l, o, w, o, r, l, d]
	
	4) Extract all distinct words from a list of sentences
			Input: ["Hello World", "Hello Java", "Stream API"]
			Output: ["Hello", "World", "Java", "Stream", "API"]
	
	5. Flatten a 2D array and double each element
			Input: {{1,2}, {3,4}, {5,6}}
			
	6) Every employees lives in multiple cities , find unique Cities


UI
=======
rerendering stop - done
debouncing - done
context vs redux - done
prmise and observable
rxjs

GC optimisation and configuration for high latency
MetaSpace and its use
save from memory leakage
memory optimisation technique
tool to identify memory leak
Loaders
abstract class behavior
SOLID principal
Immutable class
enum
Design pattern
 ===================
     Creational :  Factory, Builder , Singelton
	 Structural ; Adapter , Decorator , Composite
	 Behavioral : Strategy , Observer , State , Chain of Responsibility
	 

Multithreading
===============
Executor Service -> ThreadPool , call of threads , 1,2,3 print frm 3 threads , even odd from 2 thread
Future , use , problems
Reenterant Lock
Double Lock 
Thread Life cycle
forkJoin
How many ways thread created

======================================================================================================
Java 8 and Java 17 Features

  -- Basic Java 8  Four inbuilt Functional Interface , how to write italics
  -- Custom Functional Interface
  -- Programming based on Java 8
       ========================
	      -- String based programming  
		                      --  Single Word       :     Reverse a word , Pallindrome check , character and its count
							  -- Multiple Word    :      Reverse entire String,  Reverse each character in place , reverse each character of a word and reverse entire sentence,
							                                             pallindrome check , character and its count , Merge 2 String
																		 
																		  
		--Array based programming 
		                       -- primitive : find duplicate , find unique , number and its count and assign to map , find even , remove null and find number > 3 .
						
		-- Map based Programming 
		
		- flatMap
		- parallelStream
		-Optional.of and Optional.ofNullable
		- CompletableFuture : use , code , problem it solve
		
		-- Java 17 Features , Code to write
		
==============================================================================================================

MicroServices
==============================================================================
How many design pattern you have worked - API Gateway , Circuit Breaker , Saga , Eureka Discovery

  Explain API gateway - Which way you implemented , how to configure , why you choose that way
  Circuit Breaker  -  Which way you implemented , how to configure , why you choose that way
  Saga : Which way you implemented , how to configure , why you choose that way
  Eureka discovery : Which way you implemented , how to configure , why you choose that way
  
  Spring boot
  =========
  Suppose millions of user hits your api to fetch the data how you handle this situation.
  Suppose millions of user hits your api to save the data how you handle this situation.
  


  select odd user from table
table 1 : same column have 50 records
table 2 : same column have 25-200 records

record vs pojo class
callable vs runnable diff
which scenarios we should not use  stream
 need to fetch first 100 emp info
 
 which load balancer you have user
 how to create composite key using jpa
 how to configure EC2 with app to deploy / lambda
 
 Suppose payment you have done and inventory booked but due to time limit set , you have not be able to book the inventory
     1) how to support this system / create
	 2) How to prevent this strategies
 Named queries vs native query

 
userid , username , address - emp1
========
first 50
userid , username , address - emp2
======
emp 25-200

  select userid , username,address
   UNION ALL from emp1 , emp2 

composite primary key

 
