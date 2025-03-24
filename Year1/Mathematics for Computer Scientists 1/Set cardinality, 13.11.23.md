**Example on how does bijective lead to equinumerous-ity

Suppose we have a room that has chairs and there are people about to sit in one chair, we want to figure out if there are more people then chairs or more chairs then people or the amount of chairs are equal to the amount of people.

We can consider the function: $f : P \rightarrow C$ where $P$ are people and $C$ are chairs. 

If we want to see if there are equal amount of chairs against people then we can do the following:

First we must consider if the function is surjective which is when there are no empty chairs, if there is no empty chairs then we move onto the next step which is we consider if the function is injective. If the function isn't injective this means that no one sitting on people's lap to act that 1 chair can hold more then 1 person. If the function is both bijective and surjective then this means that the function is bijective hence the sets $P$ and $C$ have the same cardinality. 

**What is equinumerous**

When sets $A$ and $B$ have the same cardinality if there is a bijective $f : A \rightarrow B$, this can be represented using the notation $A \cong B$ 

**Equinumerous facts**

If $g: A \rightarrow B$ is injective then $A \cong B^{'}$ for some $B^{'} \subseteq B$, this can be understood more clearly using the chair analogy above

This fact is always true: $A \cong A$

If $A \cong B$ then $B \cong A$ 

If $A \cong B$ and $B \cong C$ then $A \cong C$

The equinumerous-ity "relation" is an equivalence "relation", this isn't fully true since the set of all sets doesn't exist as in order a equinumerous-ity relation to be an relation it will have to be a relation on some pairs of sets but the set of all sets doesn't exist.

But what is an equinumerous relation is an equivalence relation on every power set, for any set.

An example of this can be seen if we were to take the set $S = \{a,b,c\}$ and take its power set $\mathcal{P}(S)$ and give each element from its power set a new set where each elements cardinality will be used to determine what set it will be added to, for example $C_{0} = \{\emptyset\}$, $C_{1} = \{\{a\}, \{b\}, \{c\}\}$, $C_{2} = \{\{a,b\}, \{b,c\}, \{a,c\}\}$, $C_{3} = \{\{a,b,c\}\}$, if we take the quotient set with respect to equinumerous-ity, $\mathcal{P}(S)$ $\backslash\cong$ we can take any arbitrary element as a representative such that $\mathcal{P}(S)$ \ $\cong$  =  $\{[\langle  \emptyset \rangle ]_{\cong},  [\langle a \rangle ] _{\cong}  , [\langle b,c \rangle]_{\cong}, [\langle a,b,c \rangle ]_{\cong}\}$ we can simplify this by using our sets $C_{n}$ such that $\mathcal{P}(S)$ \ $\cong$ $\{C_{0}, C_{1}, C_{2}, C_{3}\}$ 

**Countably infinite and countable sets**

Let $F_{0} = \emptyset$, $F_{1} = \{0\}$, $F_{2} = \{0,1\}$, $F_{n} = \{k \in \mathbb{N} \mid k < n\}$

A set $S$ is finite if $S \cong F_{n}$ for some $m \in \mathbb{N}$

A set $S$ is countably infinite if $S \cong \mathbb{N}$

A set $S$ is countable if it is finite or countably infinite

A set $S$ is uncountable if it is not countable

