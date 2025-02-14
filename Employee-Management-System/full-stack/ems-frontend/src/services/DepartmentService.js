import axios from "axios";

const REST_API_BASE_URL='https://ems-5gi1.onrender.com/api/departments';

export const getAllDepartments=()=>{
    return axios.get(REST_API_BASE_URL);
}

export const createDepartment=(department)=>{
    return axios.post(REST_API_BASE_URL,department);
}

export const getDepartmentById=(departmentId)=>{
    return axios.get(REST_API_BASE_URL+'/'+departmentId);
}


export const updateDepartment=(departmentId,department)=>{
    return axios.put(REST_API_BASE_URL+'/'+departmentId,department);
}


export const deleteDepartment=(departmentId)=>{
    return axios.delete(REST_API_BASE_URL+'/'+departmentId);
}