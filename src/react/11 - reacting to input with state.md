React differs from vanilla JS as it is seen as declarative whereas vanilla JS is seen as imperative, meaning JS has to rebuild its DOM tree or update it and you are responsible of how the DOM tree would look like, this means it is easy to get into bugs or errors that are hard to track, whereas React is declarative since it has a virtual DOM which is made by our current state which can be eventually translated into a real DOM, this allows us to maintain our code much easier as we always have a state to build from and run into less bugs.

This relates to input as if we was to give React a state that we want to be on, then React can cleverly figure its way out given that the state is valid, vanilla JS would require a whole restructure of the DOM and would need us to command each element on what to do.

We can create some steps that must be completed to make an efficient program which could be in many states, for our program we will be making a text box which would be used to answer a question that will also have a button to submit our answer, the button will be disabled if the text box is empty and then valid whenever the text box has some value, if the value is wrong when pressing the button, then we will output a message that this answer is wrong, if this value is correct then we will transition to another message that says that the answer is correct. We will also add a spinner when the user attempts an answer in the form of a timer and the text box is disabled during this spinner.
#### Step 1: Identify states that the user may see
- Empty: button is disabled
- Typing: button is enabled
- Submitting/Spinner: text box is disabled, spinner is shown
- Success: correct answer, output that it was correct
- Error: same as Typing state but with an extra message

Before we go straight into making the whole program, it is recommended to make a lesser version of this current program by omitting some states such as the spinner state or the success state.

It can be useful if we was to output multiple states at once, by calling our component multiple times but with a prop that can define a different state, allowing us to see what transitions into what and makes it easier to visualise each state and the program as a whole.
#### Step 2: Determine what causes a state to change
There are two types of inputs that a state could be given and cause a transition to another state, these are human inputs and computer inputs, a human input could be simply just a button being clicked, or a text box no longer being empty. A computer input could be a network response that is arriving or an image that is being loaded in. For our specific program we can define some inputs that cause a state transition:
- Changing text input (human): should switch to Typing state or back
- Clicking button (human): should switch to Submitting/Spinner state
- Successful network response (computer): should switch to Success state
- Failed network response (computer): should switch to Error state
![[Pasted image 20250916142044.png]]
#### Step 3: Represent our states with useState
Our goal here is to represent our states with the fewest state variables we can as maintaining and changing different state variables that could be combined would lead to repetitive and hard to track code. For our program we have some state variables that must be considered and are our `answer` variable and whether we had an earlier `error` or not: 
```jsx
const [answer, setAnswer] = useState('');
const [error, setError] = useState(null);
```
Next we need to consider state variables that would be a visual state as there are many different visual states in this program, a good way of making our state variables as concise as possible is to start listing every state with there own state variable and then seeing if any of them can be related or be represented using one state variable via a string:
```jsx
const [isEmpty, setIsEmpty] = useState(true);  
const [isTyping, setIsTyping] = useState(false);  
const [isSubmitting, setIsSubmitting] = useState(false);  
const [isSuccess, setIsSuccess] = useState(false);  
const [isError, setIsError] = useState(false);
```

Our values above have some overlapping which are impossible for some, for example: we cannot have `isTyping` and `isSubmitting` to be `true` at the same time meaning we can combine them, we can also include `success` into this merge as it cannot be `true` while `isTyping` and `isSubmitting` is also true.

`isEmpty` and `isTyping` cannot be true also, if we made them separate then they could be out of sync and cause bugs and `isEmpty` can be checked if `answer.length` is `0` meaning we can omit `isEmpty`
```jsx
const [answer, setAnswer] = useState('');  
const [error, setError] = useState(null);  
const [status, setStatus] = useState('typing'); // 'typing', 'submitting', or 'success'
```
We can verify that these are essential as if we was to remove any of them, then our program won't work at all.

Now we can use these state variables to complete our program as we now know these state variables are enough to complete what we want:
```jsx
import { useState } from 'react';

export default function Form() {
  const [answer, setAnswer] = useState('');
  const [error, setError] = useState(null);
  const [status, setStatus] = useState('typing');

  if (status === 'success') {
    return <h1>That's right!</h1>
  }

  async function handleSubmit(e) {
    e.preventDefault();
    setStatus('submitting');
    try {
      await submitForm(answer);
      setStatus('success');
    } catch (err) {
      setStatus('typing');
      setError(err);
    }
  }

  function handleTextareaChange(e) {
    setAnswer(e.target.value);
  }

  return (
    <>
      <h2>City quiz</h2>
      <p>
        In which city is there a billboard that turns air into drinkable water?
      </p>
      <form onSubmit={handleSubmit}>
        <textarea
          value={answer}
          onChange={handleTextareaChange}
          disabled={status === 'submitting'}
        />
        <br />
        <button disabled={
          answer.length === 0 ||
          status === 'submitting'
        }>
          Submit
        </button>
        {error !== null &&
          <p className="Error">
            {error.message}
          </p>
        }
      </form>
    </>
  );
}

function submitForm(answer) {
  // Pretend it's hitting the network.
  return new Promise((resolve, reject) => {
    setTimeout(() => {
      let shouldError = answer.toLowerCase() !== 'lima'
      if (shouldError) {
        reject(new Error('Good guess but a wrong answer. Try again!'));
      } else {
        resolve();
      }
    }, 1500);
  });
}
```

The main benefit of React is that we can add more states without breaking other states as they are all independent.
