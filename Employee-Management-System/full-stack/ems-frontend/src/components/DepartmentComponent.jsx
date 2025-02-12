import React,{useEffect, useState} from 'react'
import { createDepartment, getDepartmentById, updateDepartment } from '../services/DepartmentService';
import { useNavigate,useParams } from 'react-router-dom';
const DepartmentComponent = () => {


   const[departMentName,setDepartMentName]=useState('')
  const[departmentDescription,setDepartmentDescription]=useState('')

  const navigator=useNavigate();

  const{id}=useParams();

  // when the update page load it display the corresponding data
  useEffect(()=>{
    getDepartmentById(id).then((response)=>{
        setDepartMentName(response.data.departMentName)
        setDepartmentDescription(response.data.departmentDescription)
    }).catch((error)=>{
        console.log(error)
    })

  },[id])

  function saveOrUpdateDepartment(e)
  {
    e.preventDefault();
    const department={departMentName,departmentDescription};

    if(id)
    {
        // call the Update Department REST API If id is present means
                         updateDepartment(id,department).then((response)=>{
                            console.log(response.data)
                            navigator('/departments')
                         }).catch(error=>{
                            console.log(error)
                         })
    }
    else{
 

              // call the Add Department REST API
                createDepartment(department).then((response)=>{
                    console.log(response.data)
                    navigator('/departments')
               }).catch(error=>{
                console.log(error)
               })
    console.log(department);
  }
}


  function pageTitle()
  {
    if(id)
    {
        return <h2 className='text-center'>Update Department</h2>
    }
    else{
        return <h2 className='text-center'>Add Department</h2>
    }
  }


  return (
    <div className='container'>
        <br/>
        <br/>
        <div className='row'>
            <div className='card col-md-6 offset-md-3 offset-md-3'>
                {
                pageTitle()
                }
                <div className='card-body'>
                    <form >
                          <div className='form-group mb-2'>
                            <label className='form-label'>Department Name:</label>
                            <input
                            type='text'
                            name='departMentName'
                            placeholder='Enter department name'
                            value={departMentName}
                            onChange={(e)=>{setDepartMentName(e.target.value)}}
                            className='form-control'

                            />

                          </div>


                          <div className='form-group mb-2'>
                            <label className='form-label'>Department Description:</label>
                            <input
                            type='text'
                            name='departmentDescription'
                            placeholder='Enter department description'
                            value={departmentDescription}
                            onChange={(e)=>{setDepartmentDescription(e.target.value)}}
                            className='form-control'

                            />

                          </div>

<br/>

                          <button className='btn btn-success'onClick={(e)=>saveOrUpdateDepartment(e)}>Submit</button>
                    </form>
                </div>
            </div>
        </div>
      
    </div>
  )
}

export default DepartmentComponent
