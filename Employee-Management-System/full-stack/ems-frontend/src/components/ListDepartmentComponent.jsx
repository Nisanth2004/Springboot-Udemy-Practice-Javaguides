import React, { useEffect, useState } from 'react'
import { deleteDepartment, getAllDepartments } from '../services/DepartmentService';
import { Link } from 'react-router-dom';
import { useNavigate,useParams } from 'react-router-dom';

const ListDepartmentComponent = () => {

    const[departments,setDepartments]= useState([]);

  const navigator=useNavigate();

  // when the component mount it get all departments
    useEffect(()=>{

    listOfDepartments()

    },[])



    function listOfDepartments()
    {
        getAllDepartments().then((response)=>{
            console.log(response.data);
            setDepartments(response.data)
        }).catch((error)=>{
            console.log(error)
        })
    }
    function updateDepartment(id)
    {
        navigator(`/edit-department/${id}`)
    }


   function removeDepartment(id)
   {
    console.log(id)
    deleteDepartment(id).then((response)=>{
      listOfDepartments();

    }).catch(error=>{
        console.error(error)
    })
   }



  return (
    <div className='container'>
        <h2 className='text-center'>List of Departments</h2>
        <Link to='/add-department' className='btn btn-primary mb-2'>Add Department</Link>
        <table className='table table-striped table-bordered'>
            <thead>
                <tr>
                    <th>Department Id</th>
                    <th>Department Name</th>
                    <th>Description</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                {
                    departments.map((department)=>(
                        <tr key={department.id}>
                            <td>{department.id}</td>
                            <td>{department.departMentName}</td>
                            <td>{department.departmentDescription}</td>
                            <td>
                            <button className='btn btn-info' onClick={()=>updateDepartment(department.id)} >Update</button>
                            <button className='btn btn-danger' onClick={()=> removeDepartment(department.id)}
                                style={{marginLeft:'10px'}}
                                >Delete</button>
                             </td>

                        </tr>
                    ))
                }
            </tbody>

        </table>
      

    </div>
  )
}

export default ListDepartmentComponent
