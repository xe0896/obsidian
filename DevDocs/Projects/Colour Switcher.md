The way this documentation went wasn't how it should be since I wasn't documenting while creating the solution, there will still be some thought processes here and there for the solution but for the most part it will just be explaining the code.
## Introduction

This program takes in a `.png` file that has a white background and changes the colour of the background to make it look nicer when you want to use images for Anki or Obsidian or any other type of other program that could showcase an image. `numpy` was used to make the colour conversion more efficient rather then just doing the following:

```python
for x in range(height):
	for y in range(width):
		r, g, b = img.getPixel(x,y)
		# RGB logic..
```

Furthermore, instead of the terminal as an interface, `Tkinter` was used as a GUI to input some values that allows the user to suit their needs, there was also some considerations of showcasing the image to the user on the GUI so I used modules such as `Pillow` to showcase it easier as `Tkinter` and `Pillow` integrate nicely.
## Colour switching

The main idea of the colour switching was to invert the image, i.e: turn black into white and white into black, then we create a mask such that if a pixel's RGB is `0` then the mask is `True`, else `False`, then we apply this mask and when it finds a match it will replace the RGB with the given RGB by the user, this will effectively convert a white background to the users wanted background. 

The program for the colour conversion relied on imports, since they are heavily used, the following imports used where:

```python
import numpy as np
from PIL import Image
```

When using anything from `numpy` we use `np` as the namespace is now `np` from the `as` keyword, from the `Pillow` module since we only want the `Image` function we do `import Image`.

Before we start manipulating the image, we must first convert the file as the special `numpy` array and also check to see if there are any alpha channels in the file:

```python
img = Image.open(data) # data = x.png where x is file name
image_arr = np.array(img)
channels = image_arr.shape[2]
```

The reason we store the channels will become apparent soon but about the way we do it is by using `np.shape` which returns the dimensions of the array and if `channels == 4` then we can assume it has an alpha channel (RGBA)

```python
if channels == 4:
	inverted_arr = 255 - image_arr[:,:,:3]
	inverted_arr = np.clip(inverted_arr, 0, 255)
	inverted_arr = np.dstack([inverted_arr, image_arr[:,:,:3]])
else:
	inverted_arr = 255 - image_arr
	inverted_arr = np.clip(inverted_arr, 0, 255)
```

The first if-statement checks to see if the alpha channel is present, if this is the case we first invert the RGB channels and leave the alpha channel for now, we then use the `np.clip()` function to ensure that our values are in the range `0-255`, then we use `np.dstack()` which combines our inverted array with the alpha channel from the original array. If there is no alpha channel we can just invert the whole array.

```python
is_black = np.all(inverted_arr = [0, 0, 0, 255], axis = -1)
inverted_arr[is_black] = [r, g, b, 255]
Image.fromarray(inverted_array).save('output.png')
```

`is_black` is a mask that checks all the RGB values via `np.all()`, notice that we assume alpha is `255` as the alpha channel for majority of the tests done had alpha as `255` so it was just a lazy solution, `axis` ensures that we check individual pixels. 

The above code was in encapsulated in a function `def process(data, r, g, b):` where `r,g,b` are values given by the user via the GUI respectively.

## Tkinter GUI

`main.py` contains the GUI stuff to make it the logic separated and also since I wanted to learn how we can make two `.py` files use each other:

```python
import calc
```

The above was imported in `main.py` as the colour conversion stuff was located at `calc.py`, this allows us to access `calc.py` functions and variables, we could of done `from calc import process` as our function was named `process` but the aliasing that `import calc` gives us was helpful since we could do `calc.process()` and ensure no other modules that contained `process` clashed if we just done `process()`

