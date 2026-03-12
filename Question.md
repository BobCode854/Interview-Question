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
