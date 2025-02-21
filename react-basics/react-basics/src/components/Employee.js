import React from "react";

class Employee extends React.Component
{
    // in class componet how to use the state variable
    constructor(props)
    {
        super(props)
        this.state={
            firstname:"Sujith"
        }
    }


    render()
    {
        return(

            <div>
                <h1>firstname:<p>{this.state.firstname}</p></h1>
                </div>
        )
    }
}

export default Employee;