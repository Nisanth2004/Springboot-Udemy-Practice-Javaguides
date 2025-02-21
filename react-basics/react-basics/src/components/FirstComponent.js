import React from 'react'

 const FirstComponent = () => {

    const name="Preethika";
    function handleClick (){

        alert("Hi");

    }
  return (
    <div>
      <h1>Nisanth</h1>
      <h1>{name}</h1>
      <button onClick={handleClick}>Submit</button>
    </div>
  )
}

export default FirstComponent;
