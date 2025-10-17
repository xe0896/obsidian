### Pointers and Addresses

| Code             | Meaning                                  |
| ---------------- | ---------------------------------------- |
| `int x`          | `x` is an integer                        |
| `int& reference` | `reference` is a reference to an integer |
| `int* pointer`   | `pointer` is a pointer to an integer     |
| `&x`             | address of `x`                           |
| `*ptr`           | pointer of `x`                           |
`int& reference` and `&x` are not related, but `int* pointer` and `*ptr` are. The use for `int& reference` is to create an alias for an existing variable and has nothing to do with the addresses. 

Pointers must always point to an address, where that address is pointing to a value that we can read
