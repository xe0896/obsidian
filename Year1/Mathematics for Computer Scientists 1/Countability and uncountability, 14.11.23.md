
**Examples of countable sets**

1) $\mathbb{N}$ \ $\{0\} \cong \mathbb{N}$, to prove that this is countable we must create a bijection between the two sets and we can do this by taking arbitrary element $x$ and create a function that maps this $x$ to the other set, we can do this if we do $x \mapsto x - 1$ this is from making a function $f: \mathbb{N}$ \ $\{0\} \rightarrow \mathbb{N}$, the bijection function can also be seen by doing $f(x) = x - 1$ which is a bijection function as it is surjective and injective. 
2) Let $E = \{n \in \mathbb{N} \mid n = 2k, k \in \mathbb{N}\}$, and $E \cong \mathbb{N}$, to prove this we create a simple bijection $f: \mathbb{N} \rightarrow E$ and the function will be $x \mapsto 2x$, this is surjective as every value $2x$ will be mapped and is injective since every other element $x$ we will get a unique $2x$. 
3) $\mathbb{Z} \cong \mathbb{N}$, we can assign each element of the integers with the natural numbers by doing the following pairs (0,0), (1,1), (2,-1), (3,2)... we can enumerate this by doing the following code:

	c = 0
	print((c,0))
	for i in range(1,2,3...)
		c = c + 1
		print((c,i))
		c = c + 1
		print((c,-i))

This will map every element of the integers to a natural numbers this creates a bijection.

4) $\mathbb{N} \cong \mathbb{N}^{2}$, to prove this we can first list out $\mathbb{N}^{2}$ and find a pattern to help us create a bijection function between it and $\mathbb{N}$:

	(0,0) (1,0) (2,0) (3,0)
	(0,1) (1,1) (2,1) (3,1)
	(0,2) (1,2) (2,2) (3,2)
	(0,3) (1,3) (2,3) (3,3)

	We can enumerate this set by taking diagonals and label each diagonal with $s$ and the natural number that will be assigned to each pair can be $c$.

	c = 0
	for s in range (0,1,2..)
		for i = 0 to s
		print(c(i,s-i))
		c = c + 1

	This is injective as each natural number $c$ will map to a unique element of $\mathbb{N}^{2}$ and this is surjective since for every $(k,j) \in \mathbb{N}^{2}$ it is output in iteration $s = k + j$ and $i = k$ 

5) $\bigcup_{i \in \mathbb{N}} \mathbb{N}^{i} \cong \mathbb{N}$ 
6) $\mathbb{N} \cong \mathbb{Q}$ 

**Cantor's Theorem**

If $S$ is a set then $S \ncong \mathcal{P}(S)$, to prove this we must prove that every function $f: S \rightarrow \mathcal{P}(S)$ is not surjective.

Let's take an arbitrary $f: S \rightarrow \mathcal{P}(S)$, consider the set $D_{f}$ which is the diagonal set of function $f$, $D_{f} = \{ x \in S \mid x \notin f(x) \}$. We now have to prove that $D_{f} \notin f(S)$ i.e not in the range of $f$ (not in the co-domain). We can assume that $D_{f}$ is in the range of $f$, suppose that $f(y) = D_{f}$ for some $y \in S$. If $y \in f(y)$ then $y \in D_{f}$ hence by definition of $D_{f}$, $y \notin f(y)$. If $y \notin f(y)$ then $y \notin D_{f}$ hence by definition of $D_{f}$, $y \in f(y)$. Therefore by the two cases $f(y) \neq D_{f}$, therefore there is no such $y$, therefore $D_{f}$ is not in the range of $f$, then $f$ cannot be surjective meaning $f$ cannot be bijective, therefore no bijection exists for $f: S \rightarrow \mathcal{P}(S)$