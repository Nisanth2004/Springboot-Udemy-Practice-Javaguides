import React, { useState } from 'react'

const EventHandling = () => {
    const[count,setCount]=useState(0);
   function handelClicked()
   {
    setCount(count+2)
   }

   function handleReset()
   {
    setCount(0);
   }
  return (
    <div>
        <h1>Event handling example</h1>
<p>Count:{count}</p>
<button onClick={handelClicked}>Increment</button>      
<button onClick={handleReset}>Reset</button>    
    </div>
  )
}

export default EventHandling
