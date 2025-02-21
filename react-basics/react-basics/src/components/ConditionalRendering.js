import React, { useState } from 'react'

const ConditionalRendering = () => {

    const[isLoggedIn,setIsLoggedIn]=useState(false);

    let message;
    if(isLoggedIn)
    {
        message=<h1>Welcome User</h1>
    }
    else{
        message= <p>Please Login</p>
    }

    function handleLogin()
    {
        setIsLoggedIn(true);
    }

    return(
        <div>
            {
                isLoggedIn &&<h1>Welcome User</h1>
            }
           
            <br/>
            <button onClick={handleLogin}>Login</button>
        </div>
    )
  
}

export default ConditionalRendering
