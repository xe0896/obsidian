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

