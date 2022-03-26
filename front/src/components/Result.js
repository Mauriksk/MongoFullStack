import React from 'react'
import { connect } from 'react-redux';
const Result = (props) => {
  
  return <div>
      {props.result && 'Resultado: '+ props.result} 
      {props.result && "Hay cosas"}
      {
        props.boletos && props.boletos.map( p => <div> {p} </div> )
      }
  </div>
}


const stateMapToPros = state => {
  return {
    result: state.boletos.result?.randomList
  }
}


export default connect(stateMapToPros)(Result)
