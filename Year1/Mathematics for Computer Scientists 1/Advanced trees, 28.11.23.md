
**What is a subgraph?**

$G^{'} = (V^{'}, E^{'})$ is a subgraph of $G = (V,E)$ if $V^{'}\subseteq V$ and $E^{'}\subseteq E$  

**What is a spanning tree?**

$G^{'} = (V^{'}, E^{'})$ is a spanning tree of $G = (V,E)$ if $V^{'} = V$ and $G^{'}$ is a tree, main idea here is that the vertices are the same and the edges are a subset of the original $G$

*Lemma 1* 

Let $G = (V,E)$ and $G$ is connected, and an edge $e$ is in a cycle $C$ in $G$. Then $G \setminus \{e\} = (V, E \setminus \{e\})$ then $G$will remain a 

Proof:  We have that $G$ is connected $\forall v,w \in V$, $\exists walk$ $v \rightarrow^{\star} w \in G$. We want to prove that $\forall v,w  \in V,$ $\exists walk$ $v \rightarrow^{\star} w \in G \setminus \{e\}$..

Let $\pi: v \rightarrow^{\star} w$ a walk in $G$, if $e$ doesn't occur in $\pi$, then this walk $\pi$ is a walk in $G \setminus \{e\}$, however if $e$ does occur in $\pi$ there is a cycle $C$ so if we remove edge $e$ we will still have a cycle $C$ that can be used to make the walk $\pi$ and that walk is in the graph $G  \setminus\{e\}$.

However if there are many occurrences of $e$ this proof doesn't consider this but we will prove later if we have a walk from $v$ to $w$ then we also have a simple path which should deal with this 

**Theorem: Every connected graph has a spanning tree**

Proof idea: keep removing edges from cycles, $G = (V,E)$ which is connected and use induction to remove these edges from cycles, i.e if it is a cyclic then this graph is a spanning tree if it is not a cyclic we will remove one edge out of it and by *Lemma 1* it is still connected and now we have one fewer edges and by the inductive hypothesis the subgraph without edge $e$ has a spanning tree.

Base case when $|E| = 0$: if a graph has 0 edges then connectivity of $G$ means that $|V| = 1$ meaning that $G$is its own spanning tree. 

Inductive step when $|E| = m \rightarrow |E| = m + 1$: Take a connected graph $G$ such that $|E| = m + 1$, if $G$ is a cyclic then $G$ is its own spanning tree, but if $G$ is not a cyclic then let edge $e$ be on a cycle $C$, recall that $G \setminus \{e\}$ is connected by *Lemma 1* and $G \setminus \{e\}$ has a spanning tree $T$ by the inductive hypothesis because the number of edges in $G \setminus \{e\}$ is $m$ and $T$ is a spanning tree of $G$

*Lemma 2* 

Let $G = (V,E)$ which is connected and $e = vw \notin E$ then $e$ is on a cycle in $G \cup \{e\} = (V, E \cup \{e\})$, in other words if you add an edge to a connected graph will create a cycle.

![[Pasted image 20231221155434.png]]

	 