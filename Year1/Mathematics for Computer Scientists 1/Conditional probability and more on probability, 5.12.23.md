
**What is conditional probability?**

Conditional probability is the probability of an event given another event we know has occurred, this is normally said in the sentence: "given that A has occurred, what is the probability of B".

To calculate the a conditional probability we use the formula: $P(A \mid B) = \frac{P(A \cap B)}{P(B)}$, this is saying given that event $B$ has occurred what is the probability of event $A$.

It is also worth to note that conditional probability $P(\cdot \mid B): \ohm \rightarrow \mathbb{R}$ is a probability measure as it satisfies the 3 axioms. 

**Joint probability theorem**

$P(A) \cdot P(B \mid A) = P(B) \cdot P(A \mid B)$ 

**What does a partition set mean?**

Events $H$ such that $H_{1}, H_{2}, H_{3}, H_{m}$ partitions $\ohm$ if:

1) $H_{1} \cup H_{2} \cup H_{3} \cup .. H_{m} = \ohm$ 
2) $H_{i} \cap H_{j} = \emptyset$, $\forall i \neq j$ 

**Law of total probability**

This allows us to calculate probabilities of an event by using their conditional probabilities given there partitioned events

If $H_{1} .. H_{m}$ partition $\ohm$, and $P(H_{i}) > 0$ $\forall i \in \{1,2,3.. m\}$ then for all events $A \subseteq \ohm$, then:

$P(A) = \sum_{i = 1}^{m} P(A \mid H_{i}) \cdot P(H_{i})$ 

![[Pasted image 20231222122923.png]]

The large circle can be seen as event $A$ and we have to find out each of the shaded area's probability and sum them up

