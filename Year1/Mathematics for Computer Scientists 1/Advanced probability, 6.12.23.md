
**Bayes Rule**

Bayes Rule states that if $H_{1}, H_{2} .. H_{m}$ partitions $\ohm$, $\forall i \in \{1,2,3, .. m\}$ and $P(A) > 0$ then:

$$P(H_{i} \mid A) = \frac{P(A \mid H_{i}) \cdot P(H_{i})}{\sum_{j = 1}^{m} P(A \mid H_{j}) \cdot P(H_{j})}$$This can be easily proved by using the law of total probability: $P(A) = \sum_{i = 1}^{m} P(A \mid H_{i}) \cdot P(H_{i})$ since $P(H_{i} \mid A) = \frac{P(H_{i} \cap A)}{P(A)} = \frac{P(A \mid H_{i}) \cdot P(H_{i})}{P(A)}$, and by putting in the formula for law of total probability in 
the denominator we get: $P(A \mid H_{i}) = \frac{P(A \mid H_{i}) \cdot P(H_{i})}{\sum_{j = 1}^{m} P(A \mid H_{j}) \cdot P(H_{j})}$

When using the Bayes Formula sometimes the probabilities $P(H_{i})$ and $P(H_{j})$ are called priors as they are what our prior beliefs where and the probabilities $P(A \mid H_{i})$ and $P(A \mid H_{j}$) are called knowns as they are probabilities that are given, using these priors and knowns we can calculate $P(H_{i} \mid A)$ which are called posteriors 

**Independent events formula**

If two events are independent then $P(A \cap B) = P(A) \cdot P(B)$

**What is a random variable?**

A random variable can be thought as some quantity that is measured with connection with a random experiment, for example rolling a 4 in a 6 sided dice. To output a random variable it could be seen as $R(a_{i})$ where $a_{i}$ is an event from a sample space $S = \{a_{1}, a_{2}, ... , a_{n}\}$ where $i \in \{1,2,3.. n\}$ 

**What is expectation?**

This can be thought as the mean of an experiment, in other words the average outcome of the experiment. 