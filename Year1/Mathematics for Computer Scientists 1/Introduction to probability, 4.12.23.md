 
**What is a sample space?**

A finite set, $\ohm$ of elementary outcomes, these elementary outcomes are sometimes called samples

Examples of $\ohm$, if we were to throw a 6-sided dice once the sample space would be $\ohm = \{1,2,3,4,5,6\}$, another example would be if we were to flip a coin twice, the sample space would be $\ohm = \{ht,th,tt,hh\}$

**What is an event?**

Events are subsets of $\ohm$. this will be useful for key information we want from the sample space, for example for our throw of a 6-sided dice an event $E$ could be $E = \{2,4,6\}$ which represent the even values that the dice will output 

There are some important events such as:

$\ohm \subseteq \ohm$ - the certain event
$\emptyset \subseteq \ohm$ - the impossible event

**What is the probability measure?**

Probability measure is the function $P: 2^{\ohm} \rightarrow \mathbb{R}$, if we do $n$ experiments and event $A$ occurs $m$ times then $P(A) \approx \frac{m}{n}$ 

**What is a probability space?**

$(\ohm, 2^{\ohm}, P)$ is a probability space if:

a) $P(A) \geq 0, \forall A \in 2^{\ohm}$ 
b) $P(\ohm) = 1$
c) if $A \cap B = \emptyset$ then $P(A \cup B) = P(A) + P(B)$, otherwise known as $A$ being mutually exclusive which means that we will never have event $A$ and $B$ at the same time

Example of the usage of a probability space: if we had a biased coin and flip it only once then the following probabilities will be true:

$\ohm = \{h,t\}$
$P(\emptyset) = 0$ 
$P(\{t\}) = 0.6$ 
$P(\{h\}) = 1 - 0.6 = 0.4$
$P(\ohm) = 1$

**Why does $P(\emptyset) = 0$?

$P(\emptyset) = 0$ since $P(\ohm \cup \emptyset) = P(\ohm) + P(\emptyset)$, and we know that $P(\ohm \cup \emptyset) = P(\ohm)$, so now we have that $P(\ohm) = P(\ohm) + P(\emptyset) \implies P(\emptyset) = 0$ 

**What does it mean for an event to be a complement?**

$\forall A \in 2^{\ohm}$, let $\bar{A} = \ohm \setminus A$, this is called the complement of $A$. 

$P(\bar{A}) = 1 - P(A)$, this is because $P(A \cup \bar{A}) = P(A) + P(\bar{A})$, and $P(A \cup \bar{A}) = 1$ so know we have $1 = P(A)+ P(\bar{A}) \implies P(\bar{A}) = 1 - P(A)$ 

**Additional facts**

If $\ohm = \{\omega_{1}, \omega_{2}, \omega_{3}, .. \omega_{k}\}$ and $p_{i} = P(\{\omega\})$, $\forall i \in \{1,2,3,4.. k\}$ then for $E \subseteq \ohm$, $P(E) = \sum_{i: \omega \in E} p_{i}$ and that $\sum_{i = 0}^{n} p_{i} = 1$ 

$P(A \cup B) = P(A) + P(B) - P(A \cap B)$ 

**Union bound theorem**

$P(A \cup B) \leq P(A) + P(B)$, to prove this is straight forward as we know that $P(A \cup B) = P(A) + P(B) - P(A \cap B)$, this is already similar to the inequality since $P(A \cap B)$ cannot be smaller then $0$ meaning we are subtracting a non-negative number so this inequality must be true as even if $P(A \cap B)$ is large or small $P(A) + P(B)$ will always be greater