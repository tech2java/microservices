https://getlearntech.com/java-8-coding-and-programming-interview-questions/
https://blog.devgenius.io/java-8-coding-and-programming-interview-questions-and-answers-62512c44f062
https://blog.devgenius.io/java-8-real-time-coding-interview-questions-and-answers-fce01f3c4080
https://www.ccbp.in/blog/articles/java-8-coding-interview-questions-and-answers
https://javaconceptoftheday.com/java-8-interview-sample-coding-questions/


//Q1.Write a Java 8 program to filter even numbers from a list ?

public static void main(String[] args) {

	
	var list= List.of(1,4,2,7,5,9,10);
	//var numList=Arrays.asList(1,4,2,7,5,9,10);

	var evenList=list.stream().filter(x->x%2==0).collect(Collectors.toList());
	System.out.println(evenList);

	var evenList1=list.stream().filter(x->x%2==0).toList();
	System.out.println(evenList1);
}

//Q2.Write a Java 8 program to calculate the sum of integers in a list ?

public static void main(String[] args) {
	var list= List.of(1,4,2,7,5,9,10);

	//Sum, min, max, average, and string concatenation are all special cases of reduction
	//var sum=list.stream().reduce(0,(x,y)->x+y).intValue();
	var sum=list.stream().reduce(0,Integer::sum);
	System.out.println(sum);

}

//Q3. Calculate the sum of 1st 20 numbers.

public static void main(String[] args) {
	
	var total=Stream
				   .iterate(1,n->n+1)
				   .limit(20)
				   .reduce(0,Integer::sum);
	System.out.println(total);
}

//Q4. Write a Java 8 program to find the maximum and minimum element from a list ?
public static void main(String[] args) {

	var list=List.of(3,1,6,4,19,18);

	int maxValue=list.stream().max((x,y)->x>y?1:(x<y?-1:0)).get();
	System.out.println(maxValue);

	int minValue=list.stream().min((x,y)->x>y?1:(x<y?-1:0)).get();
	System.out.println(minValue);

	var max=list.stream().max(Integer::compareTo);
	System.out.println(max.orElse(Integer.MAX_VALUE));
	}
	
//Q5: Write a Java 8 program to check if a list contains a specific element ?
	
public static void main(String[] args) {
	
	var list=List.of(3,5,9,1,90,40);
	int number=9;
	var match=list.stream().anyMatch(x->x==number);
	System.out.println(match);
}

//Q6.find the sum of all even numbers in a list of integers ?
public static void main(String[] args) {

		
	var list=List.of(3,5,9,1,90,40);

	var evenSum=list.stream().filter(x->x%2==0).reduce(0,Integer::sum);
	System.out.println(evenSum);

	var evenSum1=list.stream().filter(x->x%2==0)
					.mapToInt(n->n)
					.sum();
	System.out.println(evenSum1);
}
	
//Q7.Write a Java 8 program to concatenate all strings in a list ?
var list=List.of("java","python","microservices");

var concatenatedStr=list.stream().collect(Collectors.joining(","));
System.out.println(concatenatedStr);	

//Q8: Write a Java 8 program to find the average length of strings in a list of strings?
public static void main(String[] args) {

	var list=List.of("java","python","microservices");

	var avgLength=list.stream().mapToInt(String::length).average();
	System.out.println(avgLength.orElse(0.0));

}

//Q9.Write a Java 8 program to count the occurrences of a given character in a list of strings?

public static void main(String[] args) {

	
	var list=List.of("apple","banana","mango");
	char targetChar='a';
	//CharSequence::chars(Returns a stream of int zero-extending the char values from this sequence.)
	IntStream intStream = list.stream().flatMapToInt(CharSequence::chars);
	intStream.forEach(System.out::println);
	System.out.println(intStream.filter(ch->ch==targetChar).count());
}

//Question 9: Write a Java 8 program to check if all elements in a list are greater than a given value?
public static void main(String[] args) {

	var list=List.of(10,34,5,23,90);
	int inValue=4;
	var result=list.stream().filter(x->x>inValue).toList().size()==list.size();
	System.out.println(result);

	var res=list.stream().allMatch(x->x>inValue);
	System.out.println(res);
}

//Question 10: Write a Java 8 program to find the factorial of a given number ?
public static void main(String[] args) {

	IntStream.rangeClosed(1,10).forEach(System.out::println);//[1,2..10]
	
	int number=5;
	var factNum=IntStream.rangeClosed(1,number).reduce(1,(x,y)->x*y);
	System.out.println(factNum);

}

//Question 11: Write a Java 8 program to remove duplicate elements from a list ?
public static void main(String[] args) {
	

	var list=List.of(34,20,10,34,78,20);

	var values=list.stream().collect(Collectors.toSet());
	System.out.println(values);

	var values1=list.stream().distinct().collect(Collectors.toList());
	System.out.println(values1);
}

//Question 12: Write a Java 8 program to find the longest string in a list of strings ?
public static void main(String[] args) {
		
	var list=List.of("apple","mango","banana");
	list.stream().mapToInt(String::length).forEach(System.out::println);
	System.out.println(list.stream().mapToInt(String::length).max());
	System.out.println(list.stream().max((s1,s2)->s1.length()-s2.length()).get());
	System.out.println(list.stream().max(Comparator.comparingInt(String::length)).get());
	System.out.println(List.of("java","genai","agenticAI").stream().collect(Collectors.groupingBy(x->x.length())));
}

//Question 13: Write a Java 8 program to convert all strings to uppercase in a list ?
public static void main(String[] args) {
	
	var list=List.of("apple","mango","banana");

	list.stream().map(x->x.toUpperCase()).forEach(System.out::println);

	var list2=list.stream().map(String::toUpperCase).collect(Collectors.toList());

	System.out.println(list2);
	var list3=list.stream().map(String::toUpperCase).toList();
	System.out.println(list3);

}

//Question 14: Write a Java 8 program to sort a list of strings in alphabetical order ?
public static void main(String[] args) {
	
	var list=List.of("apple","mango","banana","av");

	list.stream().sorted().forEach(System.out::println);

	list.stream().sorted(String::compareTo).forEach(System.out::println);

	//reverse order
	list.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);

	//length based soring
	list.stream().sorted(Comparator.comparing(String::length)).forEach(System.out::println);
}

//Question 15: Write a Java 8 program to calculate the average of even numbers in a list of integers ?
public static void main(String[] args) {
	
	var list=List.of(3,1,6,4,9,8);
	var avg=list.stream().filter(x->x%2==0).mapToInt(n->n).average();
	System.out.println(avg.orElse(0.0));

}
//Question 16: Write a Java 8 program to convert a list of integers to a comma-separated string ?
public static void main(String[] args) {
	
	var list=List.of(3,1,6,4,9,8);
	var concatenatedStr=list.stream().map(String::valueOf).collect(Collectors.joining(","));
	System.out.println(concatenatedStr);

	var concatenatedStr1=list.stream().map(Objects::toString).collect(Collectors.joining(","));
	System.out.println(concatenatedStr1);

}
//Question 17: Write a Java 8 program to find the last element in a list ?
public static void main(String[] args) {
	
	var list=List.of(3,1,6,4,9,8);

	var firstElement=list.stream().findFirst();
	System.out.println(firstElement);

	var lastElement=list.stream().reduce((first,second)->second);
	System.out.println(lastElement);

}

//Question 18: Write a Java 8 program to find the second smallest element in a list of integers ?

public static void main(String[] args) {
		
	var list=List.of(3,1,6,4,9,8);

	var smallestNum=list.stream().sorted().collect(Collectors.toList()).get(1);
	System.out.println(smallestNum);

	var secondSmall=list.stream().distinct().sorted().skip(1).findFirst();
	System.out.println(secondSmall.orElse(0));

}

//Question 19: Write a Java 8 program to find the frequency of each word in a list of strings?
public static void main(String[] args) {

	List<String> words = List.of("apple banana apple", "banana cherry", "apple banana cherry");

	List<String> list1=new ArrayList<>();
	for(String str:words){
		list1.addAll(Arrays.stream(str.split("\\s+")).toList());
	}

	System.out.println(list1);
	System.out.println(list1.stream().collect(Collectors.groupingBy(String::toLowerCase)));//{banana=[banana, banana, banana], cherry=[cherry, cherry], apple=[apple, apple, apple]}
	System.out.println(list1.stream().collect(Collectors.groupingBy(String::toLowerCase,Collectors.counting())));

	System.out.println("###############################");

	var list=words.stream().
			flatMap(line->List.of(line.split("\\s+")).stream()).collect(Collectors.toList());
	System.out.println(list);//[apple, banana, apple, banana, cherry, apple, banana, cherry]
	System.out.println(list.stream().collect(Collectors.groupingBy(x->x.toLowerCase(),Collectors.counting())));//{banana=3, cherry=2, apple=3}

	System.out.println("###############################");

	var res=words.stream().flatMap(x-> Arrays.stream(x.split("\\s+")));
	System.out.println(res.collect(Collectors.groupingBy(String::toLowerCase,Collectors.counting())));

}
//Find Number of char occurrences in a given String
public static void main(String[] args) {

	String str="javamicroservices";
	str.chars().mapToObj(c->(char)c).forEach(System.out::println);
	System.out.println(str.chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(String::valueOf,Collectors.counting())));
}

//Question 21: Write a Java 8 program to find the distinct characters in a list of strings ?

public static void main(String[] args) {
	
	List<String> strings = List.of("apple", "banana", "cherry");

	var noDuplicates=strings.stream().collect(Collectors.joining()).chars().mapToObj(x->(char)x).collect(Collectors.toSet());
	System.out.println(noDuplicates);

	//String::chars(Returns a stream of int zero-extending the char values from this sequence)
	strings.stream().flatMapToInt(String::chars).forEach(System.out::println);//97,112,112...121

	System.out.println(strings.stream().flatMapToInt(String::chars).mapToObj(c->(char)c).collect(Collectors.toSet()));

}
	
//Question 22: Write Java 8 program to find all the numbers starting with 2 in given list ?	
public static void main(String[] args) {
		
	List<Integer> numbers = Arrays.asList(223, 234, 145, 367, 289, 2001, 2289);

	var nums=numbers.stream().mapToInt(n->n).mapToObj(String::valueOf).filter(x->x.startsWith("2")).collect(Collectors.toList());
	System.out.println(nums);

	numbers.stream().filter(x->String.valueOf(x).startsWith("2")).collect(Collectors.toList()).forEach(System.out::println);
}	

//Question 23: Write Java 8 program to find the first element of the given integers list ?
public static void main(String[] args) {
		
	List<Integer> numbers = Arrays.asList(223, 234, 145, 367, 289, 2001, 2289);

	var firstEle=numbers.stream().findFirst();

	if(firstEle.isPresent()) {
		System.out.println(firstEle.get());
	}else{
		System.out.println("No value present!!");
	}
}

//Question 24: Write Java 8 program to count the total numbers of elements in the given integers list ?
public static void main(String[] args) {
	
	List<Integer> numbers = Arrays.asList(10, 20, 30, 40, 50);
	System.out.println(numbers.stream().count());
}

//Question 25 : Write Java 8 program to sort all the values of the list in ascending order?
public static void main(String[] args) {

	List<Integer> numbers = Arrays.asList(5, 2, 8, 1, 9, 3);
	numbers.stream().sorted().forEach(System.out::println);
}

//Question 26 : Write Java 8 program to sort all the values of the list in descending order?
public static void main(String[] args) {

	List<Integer> numbers = Arrays.asList(5, 2, 8, 1, 9, 3);
	numbers.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
}

//Question 27 : Write Java 8 program to check if given integer array contains duplicate or not. Return true if it contains duplicate character

public static void main(String[] args) {
		

	int[] nums = {1, 2, 3, 4, 5,1};

	boolean b = Arrays.stream(nums)
			.boxed() // Convert int[] to Stream<Integer>
			.distinct()// Remove duplicates
			.count() != nums.length;// Check if count is different from array length

	System.out.println("Given array contains duplicates::"+b);

	var x=Arrays.stream(nums).mapToObj(n->n).collect(Collectors.toSet()).size();

	if(x==nums.length){
		System.out.println("No duplicates!!");
	}else{
		System.out.println("Present Duplicates");
	}

}

//Question 28 : Write a Java 8 program to concatenate two Streams?
public static void main(String[] args) {

	var s1=Stream.of(1,2,3);

	var s2=Stream.of(10,20,30);

	Stream.concat(s1,s2).forEach(System.out::println);
}

//Question 29 : Write Java 8 program to perform square on list elements and filter numbers greater than 1000.
public static void main(String[] args) {
	
	List<Integer> numbers = Arrays.asList(10, 20, 30, 40, 50, 110, 120);
	numbers.stream().map(x->x*x).filter(x->x>1000).forEach(System.out::println);
}

//Question 30 : Write Java 8 program to separate odd and even numbers from the given list of integers?
public static void main(String[] args) {

	List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

	var map=numbers.stream().collect(Collectors.groupingBy(x->x%2==0));

	System.out.println(map);//{false=[1, 3, 5, 7, 9], true=[2, 4, 6, 8, 10]}

	numbers.stream().collect(Collectors.partitioningBy(x->x%2==0)).forEach((k,v)->System.out.println(k +", " +v));
}

//Question 31 : Write Java 8 program to print the numbers which are multiples of 3?
public static void main(String[] args) {
	
	List<Integer> numbers = Arrays.asList(3, 6, 9, 20, 25, 40);

	numbers.stream().filter(x->x%3==0).collect(Collectors.toList()).forEach(System.out::println);
}

//Question 32 : Write Java 8 program to merge two unsorted arrays into single sorted array?
public static void main(String[] args) {

	int[] x={2,4,1,10,23,3};
	int[] y={56,40,12,100,230,223};

	var x1=Arrays.stream(x).boxed();
	var y1=Arrays.stream(y).boxed();
	//Stream.concat(x1,y1).sorted().collect(Collectors.toList()).forEach(System.out::println);


	var stream=Stream.concat(x1,y1);
	var array=stream.sorted().toArray();
	System.out.println("Sorted Array::"+Arrays.toString(array));
}

//Question 33 : Write Java 8 program to merge two unsorted arrays into single sorted array by removing duplicates?
public static void main(String[] args) {
		

	int[] x={2,4,1,10,23,3};
	int[] y={56,40,12,10,23,223};

	var x1=Arrays.stream(x).boxed();
	var y1=Arrays.stream(y).boxed();
	//Stream.concat(x1,y1).sorted().collect(Collectors.toList()).forEach(System.out::println);


	var stream=Stream.concat(x1,y1);
	var array=stream.sorted().distinct().toArray();
	System.out.println("Sorted Array::"+Arrays.toString(array));
}

//Question 34 : Java program to get first three maximum numbers and three minimum numbers from the given list of integers?
public static void main(String[] args) {

	List<Integer> numbers = Arrays.asList(10, 5, 20, 15, 25, 3, 30, 1, 8);

	numbers.stream().sorted().collect(Collectors.toList()).forEach(System.out::println);

	System.out.println("=============");
	numbers.stream().sorted().limit(3).collect(Collectors.toList()).forEach(System.out::println);

	//.sorted((a, b) -> Integer.compare(b, a)) // Sort in descending order
	numbers.stream().sorted(Comparator.reverseOrder()).limit(3).collect(Collectors.toList()).forEach(System.out::println);

}

//Question 35 : Java 8 program to check if two strings are anagrams or not?
public static void main(String[] args) {
		
	String str1 = "listen";
	String str2 = "silent";

	//var x=str1.chars().boxed().sorted().collect(Collectors.toList());
	//var y = str2.chars().boxed().sorted().collect(Collectors.toList());
	//System.out.println(x.equals(y));

	String str11 = str1.chars().mapToObj(c -> (char) c).sorted().collect(Collectors.toList()).get(0).toString();
	String str12 = str1.chars().mapToObj(c -> (char) c).sorted().collect(Collectors.toList()).get(0).toString();

	System.out.println(str11.equals(str12));

	System.out.println("==========================================");
	var sortedStr1=Arrays.stream(str1.split("")).sorted().reduce("",(x1,y1)->x1+y1);
	var sortedStr2=Arrays.stream(str2.split("")).sorted().reduce("",(x1,y1)->x1+y1);

	System.out.println(sortedStr1);
	System.out.println(sortedStr2);
}

//Question 36 : Write Java 8 program to find sum of all digits of a number ?
public static void main(String[] args) {

	
	int number = 12345;

	String str=String.valueOf(number);
	var value=Arrays.stream(str.split("")).collect(Collectors.toList()).stream().reduce("0",(x,y)-> String.valueOf(Integer.parseInt(x)+Integer.parseInt(y)));
	System.out.println(value);

	System.out.println("=================");
	var value2=Arrays.stream(str.split("")).reduce("0",(x, y)-> String.valueOf(Integer.parseInt(x)+Integer.parseInt(y)));
	System.out.println(value2);

	var value3=Arrays.stream(str.split("")).mapToInt(Integer::parseInt).sum();
	System.out.println(value3);

}

//Question 37 : Write Java 8 program to sort given list of strings according to decreasing order of their length?
public static void main(String[] args) {
	
	List<String> strings = Arrays.asList("banana", "apple", "orange", "grape", "kiwi");

	strings.stream().sorted(Comparator.comparing(String::length)).forEach(System.out::println);//ascending order

	System.out.println("=========================");
	strings.stream().sorted((s1,s2)->Integer.compare(s2.length(),s1.length())).collect(Collectors.toList()).forEach(System.out::println);//descending order

	strings.stream().sorted((s1,s2)->s2.length()-s1.length()).collect(Collectors.toList()).forEach(System.out::println);//descending order

}

//Question 38 : Write Java 8 program to find common elements between two lists?
public static void main(String[] args) {

	List<Integer> list1 = new ArrayList<>(List.of(1, 2, 3, 4, 5));
	List<Integer> list2 = new ArrayList<>(List.of(4, 5, 6, 7, 8));

	// Convert lists to sets to remove duplicates
	var set1=new HashSet<>(list1);
	var set2=new HashSet<>(list2);

	// Retain only the elements that are present in both sets
	set1.retainAll(set2);

	System.out.println(set1);
}

//Question 39 : Write Java 8 program to prints the first 5 odd numbers?
public static void main(String[] args) {
		
	Stream.iterate(1,n->n+1)
					.filter(x->x%2!=0)
					.limit(5)
					.forEach(System.out::println);

	IntStream.iterate(1,n->n+2).limit(5).forEach(System.out::println);
}

//Question 40 : Write Java 8 program to print the most repeated element in an array?
public static void main(String[] args) {
	
	int[] array = {1, 2, 3, 4, 2, 2, 3, 4, 4, 4, 5, 5, 4};

	var b=Arrays.stream(array).mapToObj(n->n).collect(Collectors.groupingBy(y->y));
	System.out.println(b);

	//boxedReturns a Stream consisting of the elements of this stream, each boxed to an Integer.)
	var res=Arrays.stream(array).boxed().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
	System.out.println(res);

	var res1=Arrays.stream(array).boxed().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
			.entrySet()
			.stream()
			.max(Map.Entry.comparingByValue()).get();
	System.out.println(res1.getKey() +"==="+res1.getValue());
}

//Question 41 : Write Java 8 program to print duplicate elements from an array?
public static void main(String[] args) {
	
	Integer[] array = {1, 2, 3, 4, 2, 3, 5, 6, 7, 8, 9, 1};

	var res=Arrays.stream(array).collect(Collectors.groupingBy(n->n,Collectors.counting()));
	System.out.println(res);

	var result1=res.entrySet().stream().filter(x->x.getValue()>1).collect(Collectors.toList());
	System.out.println(result1);//[1=2, 2=2, 3=2]

	var result2=res.entrySet().stream().filter(x->x.getValue()>1).map(t->t.getKey()).collect(Collectors.toList());
	System.out.println(result2);
}

//Question 42 : Write Java 8 program to find first repeated character in the given string?
public static void main(String[] args) {
	
	String str = "hello world";

	HashSet<Character> set = new HashSet<>();

	str.chars().mapToObj(ch->(char)ch).forEach(System.out::println);

	System.out.println("======================");
	// Filter out characters that are already in the set (i.e., repeated characters)
	var repeatedChar=str.chars().mapToObj(ch->(char)ch).filter(ch->!set.add(ch)).findFirst().get();
	System.out.println(repeatedChar);//l

}
//Question 43 : Write a Java 8 program to check if a list contains a specific string ?
public static void main(String[] args) {
		
	String searchString = "orange";
	List<String> list = Arrays.asList("apple", "banana", "orange", "grape");

	var val=list.stream().anyMatch(x->x.equals(searchString));
	System.out.println(val);

	var val1=list.stream().anyMatch(searchString::equals);
	System.out.println(val1);

	var val2=list.stream().filter(x->x.equals(searchString)).collect(Collectors.toList()).size()>0;
	System.out.println(val2);
}

//Question 44 : Write a Java 8 program print all the strings of given length ?
public static void main(String[] args) {
		
	List<String> list = Arrays.asList("apple", "banana", "orange", "grape", "kiwi");
	int targetLength = 6;

	list.stream().filter(x->x.length()==targetLength).collect(Collectors.toList()).forEach(System.out::println);

}	

//Question 45 : Write a Java 8 program print first non repetitive character in the string ?
//Question 46 : Write a Java 8 program to find the product of all elements in a list ?
public static void main(String[] args) {
		
	List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

	var value=numbers.stream().reduce(1,(x,y)->x*y);
	System.out.println(value);
}
//Question 47 : Write a Java 8 program to check if all elements in a list are unique ?
public static void main(String[] args) {
	List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5,3);
	var value=numbers.stream().collect(Collectors.toSet()).size()==numbers.size();
	System.out.println(value);
}

//Question 48 : Write a Java 8 program to find the first word in a list that starts with given letter ?
public static void main(String[] args) {
	List<String> words = List.of("apple", "banana", "orange", "grape");
	char targetLetter = 'o';

	Optional<String> first = words.stream().filter(x -> x.startsWith(targetLetter + "")).findFirst();
	System.out.println(first.get());


	Optional<String> firstLetter=words.stream().filter(x -> !x.isEmpty() && x.charAt(0)==targetLetter).findFirst();
	System.out.println(firstLetter.get());

}

//Question 49 : Write a Java 8 program to find the sum of the first 10 natural numbers ?
public static void main(String[] args) {
	var sum=IntStream.rangeClosed(1,10).sum();
	System.out.println(sum);

}
//Question 50 : Write a Java 8 program to find the product of the first 10 natural numbers ?
public static void main(String[] args) {

	var sum=IntStream.rangeClosed(1,10).reduce(1,(x,y)->x*y);
	System.out.println(sum);

}
