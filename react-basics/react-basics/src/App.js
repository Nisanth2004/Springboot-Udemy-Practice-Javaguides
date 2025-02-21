
import './App.css';
import ArraysProps from './components/ArraysProps';
import ConditionalRendering from './components/ConditionalRendering';
import Employee from './components/Employee';
import EventHandling from './components/EventHandling';
import FirstComponent from './components/FirstComponent';
import Greetings from './components/Greeting';
import Student from './components/Student';
import User from './components/User';
import Welcome from './components/Welcome';

function App() {

  // create object data
  const student={
    firstname:"Nisanth",
  lastname:"Selvaraj",
   email:"nisaselva2004@gmail.com"
  }


  const skills=['HTML','Springboot','Docker'];
  return (
    <div className="App">
      Hello World
<Welcome name="Nisanth"/>
<Greetings/>
<FirstComponent/>

<Student 
students={student}
/>

<Student 
students={student}
/>

<ArraysProps data={skills}/>


<Employee/>

<User/>

<EventHandling/>

<ConditionalRendering/>
    </div>
  );
}

export default App;
