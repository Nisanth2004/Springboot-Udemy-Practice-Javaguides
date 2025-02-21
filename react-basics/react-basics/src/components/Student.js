const Student=(props)=>{
    return(
        <div>
            <h1>Student Details</h1>
            <p>Student first name: {props.students.firstname}</p> 
            <p>Student last name: {props.students.lastname}</p>
            <p>Student email address: {props.students.email}</p>

        </div>
    )
}

export default Student;