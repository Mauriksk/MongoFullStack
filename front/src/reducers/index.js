//reducers
import { combineReducers } from 'redux'


function view(state = {
    loading: false
}, action) {
    switch (action.type) {
        //TODO: refactorizar
        case "view-loading": {
            return {
                loading: true
            }
        }
        case "view-loaded": {
            return {
                loading: false
            }
        }
        default: return state
    }
}

function random(state = {
    result: {}
}, action) {
    switch (action.type) {
        case "random-result": {
            return { result: action.data }
        }
        default: return state
    }
}

function loteria(state = {
    result: {}
}, action) {
    switch (action.type) {
        case "loteria-result": {
            return { result: action.data }
        }
        default: return state
    }
}

function boletos(state = {
    boletos: {}
}, action) {
    switch (action.type) {
        case "boletos-result": {
            return { boletos: action.data }
        }
        default: return state
    }
}


const rootReducer = combineReducers({
    view, random, loteria, boletos
})

export default rootReducer