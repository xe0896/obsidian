Components that can receive many state updates such as appending, deletion, editing, etc, can get overwhelming to look at, for example a task program that can save/edit/delete a task has several state updates and there are several calls to `setTasks` in order to update the state:

```jsx
import { useState } from 'react';
import AddTask from './AddTask.js';
import TaskList from './TaskList.js';

export default function TaskApp() {
  const [tasks, setTasks] = useState(initialTasks);

  function handleAddTask(text) {
    setTasks([
      ...tasks,
      {
        id: nextId++,
        text: text,
        done: false,
      },
    ]);
  }

  function handleChangeTask(task) {
    setTasks(
      tasks.map((t) => {
        if (t.id === task.id) {
          return task;
        } else {
          return t;
        }
      })
    );
  }

  function handleDeleteTask(taskId) {
    setTasks(tasks.filter((t) => t.id !== taskId));
  }

  return (
    <>
      <h1>Prague itinerary</h1>
      <AddTask onAddTask={handleAddTask} />
      <TaskList
        tasks={tasks}
        onChangeTask={handleChangeTask}
        onDeleteTask={handleDeleteTask}
      />
    </>
  );
}

let nextId = 3;
const initialTasks = [
  {id: 0, text: 'Visit Kafka Museum', done: true},
  {id: 1, text: 'Watch a puppet show', done: false},
  {id: 2, text: 'Lennon Wall pic', done: false},
];
```

To reduce this complexity we can keep our logic into one easy access place, we can move this state logic into a single function that is outside of the component called a "reducer".

As the logic of `useState` is pretty simple, we should try to migrate to `useSTate` to `useReducer` to make it easier to understand, there are some steps for this:
- Replace all instances of setting state to dispatching actions instead
- Create a reducer function
- Call reducer function from our component

To dispatch actions instead of setting states we should specify "what the user just did" by dispatching "actions" from our event handlers, the actual logic will be placed elsewhere. The way that we can specify the intent of the user is by giving minimal information such that our state logic is able to perform the appropriate action given this minimal information, lets say we wanted to dispatch an add action, it will look something like this:

```jsx
function handleAddTask(text) {
  dispatch({
    type: 'added',
    id: nextId++,
    text: text,
  });
}
```

As shown, we are providing an object to `dispatch` of the information that is required to add an additional task, the object we are providing is called an "action". We can provide whatever we want, we just want to make it in context.

Now, we need to create our reducer function that will be containing our state logic and it normally follows a certain pattern: two arguments (current state and action object) and it should return the next state. React will set the state to what is returned from our reducer.

Given that we have given the `dispatch` function a `type` prop to tell us what the user expects from this action, we can simply do multiple if-statements and depending on what `type` this action is the user will receive an appropriate action:

```jsx
function tasksReducer(tasks, action) {
  if (action.type === 'added') {
    return [
      ...tasks,
      {
        id: action.id,
        text: action.text,
        done: false,
      },
    ];
  } else if (action.type === 'changed') {
    return tasks.map((t) => {
      if (t.id === action.task.id) {
        return action.task;
      } else {
        return t;
      }
    });
  } else if (action.type === 'deleted') {
    return tasks.filter((t) => t.id !== action.id);
  } else {
    throw Error('Unknown action: ' + action.type);
  }
}
```

To actually make this useful and more centralised we can use the `useReducer` hook instead of `useState` which will take in two arguments: a reducer function and initial state. It will return a stateful value and a `dispatch` function that we can use to pass to our reducer function:

```jsx
const [tasks, dispatch] = useReducer(tasksReducer, initialState);
```

Reducers are working with states, meaning they must follow the principle that `useState` has been following and that is we cannot allow mutation of any sort and that they must be pure.

Reducers also have a similar thing that `useState` when it comes to `Immer`, we can do:

```jsx
import { useImmerReducer } from 'use-immer';
const [tasks, dispatch] = useImmerReducer(tasksReducer, initialTasks);
```

Allowing us to mutate our `draft` object directly in our `tasksRenderer` function as behind the scenes the draft object that `Immer` uses is given as an argument for us allowing us to mutate like we have received the `prev` state from an arrow function:
```jsx
function taskRenderer(draft, action) {
	if(action.type === "added") {
		draft.push({
			id: action.id,
			text: action.text,
		});
	} else {
		throw Error("Unknown action " + action.type);
	}
}
```


