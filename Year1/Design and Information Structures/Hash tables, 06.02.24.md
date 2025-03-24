
**Why are hash tables useful**

Hash tables are an effective data structure for implementing a map.

**What are hash functions?**

A hash function will map keys to integers in a fixed interval $[0, n -1]$  such that $n$ is the size of the map which is also known as buckets.

Example:

$h(x) = x$ $mod$ $n$ is a hash function of integer keys, the integer $h(x)$ is called the hash value of key $x$. An ideal hash function will want to map the keys to the integers in a random-like manner to ensure that the buckets are evenly distributed.

This can be done in two steps:

- Map the key to an integer
- Map the integer to a bucket

**How do hash functions work?**

A hash function is usually specified as the composition of two functions $h(k) = h_{2}(h_{1}(k))$:

The functions $h_{1}$ and $h_{2}$ are defined as:

Hash code: $h_{1}:$ keys $\rightarrow \mathbb{Z}$ 
Compression functions: $h_{2}: \mathbb{Z} \rightarrow [0, n-1]$ 

To store the item $(k,v)$ we compute its hash code then apply the compression function then store in its given index $i$ 

**More on hash codes**

It is sought after to reduce collisions in our hash code, there isn't a unique way to choose a hash code for a key meaning we cannot fully eliminate collisions but we can reduce them. 

**Polynomial hash code**

We partition the bit of the key into a sequence of components of fixed length for example using 8, 16, 32 bits: $a_{0} \cdot a_{1} ... a_{n-1}$  

**Different types of compression functions:**

Using the division method which uses the function $h_{2} = y$ $mod$ $n$ where size $n$ is usually a prime number as it reduces collisions then a non-prime number.

Using the multiply, add and divide method which uses the method $h_{2} = (ay + b)$ mod $n$ 

**What is chaining**

Chaining reduces collisions using a separate hash table by creating a new hash table, this is because different elements are mapped to the same cell meaning it could be seen as efficient to create a new hash table. 

![[Pasted image 20240206124748.png]]

However this requires more memory and if the hash function doesn't produce unique keys often we will see that a key in the form $(k,v)$ will be repeated and cause a certain key to be bloated which affects functions such as searching and deletion but it is simple to implement.

**Another way to resolve collisions**

Open addressing is known as making the colliding item placed in a different cell of the table, during insertion the goal of a collision is to find a free slot in the table, however we must be careful not to over-write data. 

Each table sell is referred to as a "probe" which allows us to use the probe sequence which is the series of slots visited following a collision resolution policy

$\beta_{0} = h(k)$ 
$(\beta_{0}, \beta_{1}, ..)$ will be the series of slots making up the probe sequence.


