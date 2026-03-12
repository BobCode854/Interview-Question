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
