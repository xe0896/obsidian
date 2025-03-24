
**Definitions**

Let $f : X \rightarrow Y$, if $f(x) = y$ then $x$ is a pre-image of $y$ under $f$, in simple terms this is saying that if $f$ sends $x$ to $y$ then intuitively the inverse of $f$ should send $y$ to $x$

**Example**

$sq: \mathbb{R} \rightarrow \mathbb{R}$ , $x \mapsto x^{2}$ 
$sq(x) = x^{2}$
$sq(-2) = 4 \land sq(2) = 4$
-2,2 are pre-images of 4

**More definitions**

The following definitions are known as complete pre-image

$f^{-1}(y) = \{x \in X : f(x) = y\}$
or
$f^{-1} : Y \rightarrow \mathcal{P}(S)$
or 
$f^{-1}(Y^{'}) = \{X \in x : f(x) = y$ for some $y \in Y^{'} \}$

In order to see if a pre-image is a function is to see if it has more then two elements or has no elements at all, since a function must have exactly one output when given an input

**Inverting relations view**

When inverting relations from set X and set Y, if two elements in set X were to of been mapped to one value in set Y, then as it is many-to-one then it is still a function. If we were to invert the relation then we will see that set Y will map to set X too two different elements in set X, we also see that an element in set Y has no value mapped to set X. These two properties of non-existence and one to many was due to the original relation on having many to one and having one value of set Y not being mapped from set X.

This isn't really on a relations view but for both relations and functions

**More definitions**

Let $f: X \rightarrow Y$, then $f$ is:

1) Injective: if $\forall x_{1}, x_{2} \in X, x_{1} \neq x_{2} \rightarrow  f(x_{1}) \neq f(x_{2})$
if you take two elements in $X$, then they must not be mapped on to the same element in $Y$. 

Also consider $h(x) = h(y) \implies x = y$ in proofs for injectivity 
Injective can also be referred to as "one-to-one"

2) Surjective: if $\forall _{y \in Y}$,  $\exists_{x \in X}$,  $f(x) = y$
for every y value in Y there must be a value of x mapped to it, there should be no lack of existence 

3) Bijective: if it is both surjective and injective

**Theorem 1** 

Let $f : X \rightarrow Y$ then f is bijective $\iff$ $f^{-1}$ is a function, works both ways

**Theorem 2 (with proof)**

Let $f : A \rightarrow B$, $g: B \rightarrow C$, then by reviewing them as relations $f \circ g$ is a function from $A$ to $C$. 

Let's recap the definition of f composed g or $f \circ g$. 

$f \circ g = \{(a,c) \in A \times C$: there is $b \in B$ such that $(a,b) \in f$ and $(b,c) \in g$

Let's consider existence:

- Want: $\forall_{a\in A}$, $\exists _{C\in C}$, $(a,c) \in f \circ g$

Take an arbitrary $a \in A$, since f is a function, $\exists b \in B$, $(a,b) \in f$

Since $g$ is a function, $\exists c \in  C$, $(b,c) \in g$       (1)

Then $(a,c) \in f \circ g$, because for $(a,c)$ to be a relation $f \circ g$ it suffices that there exists some B such that $(a,b) \in f$ and $(b,c) \in g$ which matches what we recapped for $f \circ g$

Let's now consider uniqueness:

- Want $\forall _{C^{'} \in C}$ , $(a,c^{'}) \in f \circ g \rightarrow c = c^{'}$

Suppose $(a,c^{'}) \in f \circ g$

By definition of composition, $\exists b^{'} \in B$, $(b^{'}, c^{'})$ \in g

Since $f$ is a function, then $b^{'} = b$ as from the (1) label the value of b must map to the same value

This is also the case for $g$ so $c^{'} = c$ 

**Example**

$f(x) = x^{2}$
$g(x) = x -3$

$(f \circ g)(x) = x^{2} -3$
$(g \circ f)(x) = (x-3)^{2}$

$(f \circ g)(x) = g(f(x))$

