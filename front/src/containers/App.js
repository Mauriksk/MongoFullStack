import React, { Component } from 'react'
import From from '../components/From'
import { PedirBoleto } from '../components/PedirBoleto'
import Result from '../components/Result'

class App extends Component {// component stateful
  render() {
    return (
      <div>
        <h3>Lista Random</h3>
        <p>Sistema Ramdom - Demo</p>
        <From />
        <Result />
        <hr></hr>
        <PedirBoleto />
      </div>
    )
  }
}

export default App


