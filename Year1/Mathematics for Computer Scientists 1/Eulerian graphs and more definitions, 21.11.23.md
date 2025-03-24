	
**What is a tour?**

A tour is a walk in which $v_{0} = v_{n}$, it comes back to where it started

**What is a cycle?**

A cycle is a tour with no edges repeated 

**What is a simple cycle?**

A tour with no vertices repeated except for $v_{0} = v_{n}$ 

**Additional notations**

$v \rightarrow w: v$ $w \in E$ 
$v \rightarrow ^{\star} w:$ there exists a walk from $v$ to $w$

**The Reachability Relation**: $\rightarrow ^{\star} \subseteq V^{2}$ 

The reachability relation is an equivalence relation only for undirected graphs, to prove this we see if this is reflexive and it is reflexive as we can make the walk length 0 and make $v \rightarrow ^{\star} v$ true. 

To prove that this is symmetric since we are only considering undirected graphs the symmetric traversal of $v \rightarrow ^{\star} w$ is $w \rightarrow ^{\star} v$ and to get symmetric traversal we can just go backwards from $w$ to $v$ since the graph is undirected.  

To prove that this is transitive i.e prove that $v \rightarrow ^{\star} w$ and $w \rightarrow ^{\star} u$ meaning $v \rightarrow ^{\star} u$ holds we can just combine the two walks to get one single walk

**What is a connected component**

The equivalence class for this reachability relation $\rightarrow ^{\star}$ is a  connected component of a graph $G$, meaning the definition for a graph to be connected is for it to have exactly one connected component

**What is an Eulerian cycle?**

A cycle is Eulerian if every edge $e \in E$ occurs on it exactly once

**What is an Eulerian graph?**

A graph is Eulerian if it has an Eulerian cycle

**What is a Hamiltonian cycle**

A cycle is Hamiltonian if every vertex $v \in V$ occurs on it exactly once

**Euler, Hievholzer theorem**

The theorem states that a graph $G = \{V,E\}$ that is undirected and without considering isolated vertices as they are irrelevant will be Eulerian $\iff$  it is connected and degrees of all vertices are even. 

To prove this we must prove that if a graph is Eulerian then it is connected and degrees of all vertices are even and also prove that if a graph is connected and degrees of all vertices are even then it is Eulerian, this is the fundamentals of proving with equivalence, $\iff$. We know that $P \iff Q = (P \implies Q) \land (P \impliedby Q)$. $\implies$ is usually known as necessity and $\impliedby$ is known as sufficiency. In other words it is a necessity that a graph is connected and degrees of all vertices are even to be Eulerian whereas the other condition states that it is sufficient that a graph is Eulerian if it connected and degrees of all vertices are even. 

Let's prove for necessity, i.e: $G$ is Eulerian $\iff$ it is connected and degrees of all vertices is even.
Let $C: v_{0} \rightarrow v_{1} \rightarrow v_{2} ... \rightarrow v_{n}$ and $C$ is an Eulerian cycle in $G$ (note that $v_{0} = v_{n}$). What we want to prove is that $\forall v \in V$, $deg(v)$ is even . If $t$ is the number of times $v$ is visited in $v_{0}, v_{1}, v_{2} ... v_{n-1}$ then $deg(v) = 2 \cdot t$  which is even as we go $in$ and we go $out$. 

We also need to prove that $G$ is connected. What we want to prove is that $\forall v,w \in V$, that $v \rightarrow^{\star} w$, in other words $w$ is reachable from $v$. Since we are not considering isolated vertices $deg(v), deg(w) > 0$ hence $v,w$ occurs on $C$. Let $v = v_{i}$ , $w = v_{j}$, $wlog$ $i < j$. $v_{i} \rightarrow v_{i+1}... \rightarrow v_{j}$ is a walk. Hence $v_{i} \rightarrow^{\star} v_{j}$ and since the reachability relation on undirected graphs is symmetric we also have that $v_{j} \rightarrow^{\star} v_{i}$ . This means that the two vertices $v,w$ are in the same connected component and since these were arbitrary vertices this applies to all vertices and if all vertices are in the same connected component then there is only one connected component and if there is only one connected component the graph is connected. 


