import { useState } from "react"

const User=()=>{


   // const[firstname,setFirstname]=useState("Nisanth");
    //const[lastname,setLastname]=useState("Selvaraj");
   // const[email,setEmail]=useState("nisa@gmail.com");
const[user ,setUser]= useState({
    firstname:"Nisanth",
    lastname:"selvraj",
    email:"prethi@gmail.com"
})
    function updateUser()
    {
        setUser({
            firstname:"Preethika",
            lastaname:"pal",
            email:"preethi@gmail.com"
        })

       // setFirstname("Preethika")
       // setLastname("Ppp")
       // setEmail("nisanthselva2004@gmail.com")
    }

    return(

        <>
        <h1>User Details</h1>
        <p>{user.firstname}</p>
        <p>{user.lastname}</p>
        <p>{user.email}</p>
        <button onClick={updateUser}>Update User</button>


</>
    )
}

export default User;