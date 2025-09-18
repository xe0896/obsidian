Flexbox is a method provided by CSS to easily create layouts for stuff like navigation bars or text blocks, and all depends on our display being `display: flex`. 

Each element that has a display of `flex` will have a invisible axis, the main axis and the cross axis where the main axis is the x-axis and cross axis is the y-axis:
![[Pasted image 20250917143737.png]]

Our items will be along these axis and can be manipulated by using `justify-content` for the main axis and `align-items` for the cross axis:

`justify-content` has many values it can take:

|     Attribute     |                                             Explaination                                             |
| :---------------: | :--------------------------------------------------------------------------------------------------: |
|   `flex-start`    |                             Align items from the start of the main axis                              |
|    `flex-end`     |                              Align items from the end of the main axis                               |
|     `center`      |                              Align items on the center of the main axis                              |
| `space-inbetween` | Distributes items evenly on the main axis, with the first item on the start and last item at the end |
|  `space-around`   |                          Distributes items with even space in between them                           |
|  `space-evenly`   |                         Distributes items with even space between each other                         |
`align-items` has *some* values that `justify-content` can take, and the reason why it is only a few is because `align-items` is to align a single line of items and we can't make them have a value like `space-inbetween` because they are a single group, it should not be used to distribute empty space, if we wanted to do that then we should use `align-content` instead where there will be multiple lines, we will focus on `align-items` first:

|  Attribute   |                 Explaination                 |
| :----------: | :------------------------------------------: |
| `flex-start` | Align items from the start of the cross axis |
|  `flex-end`  |  Align items from the end of the cross axis  |
|   `center`   | Align items on the center of the cross axis  |
|  `stretch`   |                                              |
We can also manipulate the main axis by using `flex-direction` which would make other properties of the flexbox change:

| Attribute |                Explaination                 |
| :-------: | :-----------------------------------------: |
|   `row`   |      Default value of `flex-direction`      |
| `column`  |       Main axis swaps with cross axis       |
| `center`  | Align items on the center of the cross axis |
| `stretch` |                                             |


