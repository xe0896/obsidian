
**What does it mean to be adjacent?**

For edges such that $e = v$ $w \in E$, we say that these two vertices $v$ and $w$ are adjacent

**What does incidence mean?**

For edges such that $e = v$ $w \in E$, we say that an edge $v$ or $w$ are incident on $e$ or we can say that $e$ is incident on $v$ or $w$

**What does destination mean?**

For edges such that $e = (v,w) \in E$, we say that $v$ is the source and $w$ is the destination, this can also work for undirected graphs so either $v$ or $w$ can be the source or destination but for ordered only one can be a destination and the other can be a source. 

**What is a vertex degree?**

A vertex's degree is the number of edges that is incident on this vertex and is normally outputted by the function $deg(v)$ where $v \in V$ for a graph $G = (V,E)$, note that we will count self-loops twice. In simpler terms this definition can be thought as how many edges are inputted and outputted from a vertex. 

There are two more functions related to degrees one is $in$-$deg(v)$ which are the number of edges from a vertex $v$ where $v$ is the destination of the edge and the other function is $out$-$deg(v)$ which are the number of edges from a vertex $v$ where $v$ is the source of the edge. 

**The Handshaking Lemma**

The total number of degrees in a graph can be seen as:  $\sum_{v \in V}deg(v) = 2 \cdot |E|$ 

The proof is as follows: the LHS shows us the number of endpoints of all edges and LHS = RHS since every edge has exactly 2 endpoints, its source and its destination. 

**What does it mean when two graphs are isomorphic?**

When two simple graphs $G_{1} = (V_{1}, E_{1})$ and $G_{2} = (V_{2}, E_{2})$ are isomorphic when if there is a bijective function $f: V_{1} \rightarrow V_{2}$ such an ($f$ will be called an isomorphism between $G_{1}$ and $G_{2}$) and 
$\forall v_{1}, v_{2} \in V_{2}: v_{1}, v_{2} \in E_{1} \iff f(v_{1}) \land f(v_{2}) \in E_{2}$. The notation used to show two graphs are isomorphic is $G_{1} \cong G_{2}$ 

**What is** $K_{n}$? 

$K_{n}$: for the unique (up to isomorphism) graph on $n$ vertices and with $\frac{n(n-1)}{2}$ edges 

![[Pasted image 20231215181225.png]]


If we have a graph $G = (V,E)$ ; $v_{0}, v_{n} \in E$

**What does it mean when two graphs are isomorphic?**

When two simple graphs $G_{1} = (V_{1}, E_{1})$ and $G_{2} = (V_{2}, E_{2})$ are isomorphic when if there is a bijective function $f: V_{1} \rightarrow V_{2}$ such an ($f$ will be called an isomorphism between $G_{1}$ and $G_{2}$) and 
$\forall v_{1}, v_{2} \in V_{2}: v_{1}, v_{2} \in E_{1} \iff f(v_{1}) \land f(v_{2}) \in E_{2}$. The notation used to show two graphs are isomorphic is $G_{1} \cong G_{2}$ 

**What is** $K_{n}$? 

$K_{n}$: for the unique (up to isomorphism) graph on $n$ vertices and with $\frac{n(n-1)}{2}$ edges 

![[Pasted image 20231215181225.png]]


If we have a graph $G = (V,E)$ ; $v_{0}, v_{n} \in E$

**What is a walk?**

A walk from $v_{0}$ to $v_{n}$ of length $n$, is the finite sequence $v_{0}, v_{0}v_{1}, v_{1}, v_{1}v_{2}, v_{2} ... v_{n}$, where $v_{0},v_{1},v_{2},v_{n}$ are vertices and $v_{0}v_{1}, v_{1}v_{2}, v_{n-1}v_{n}$ are edges.

**What is a path?** 

A path is a walk in which no edge is repeated

**What is a simple path?**

A walk in which no vertex is repeated and for no vertex repeated it will mean that no edge is repeated $P \rightarrow Q$. 


