const React = require('react');
const ReactDOM = require('react-dom');
const client = require('./client');

class App extends React.Component {

    constructor(props) {
        super(props);
        this.state = {stuff: []}
    }
    componentDidMount() {
        let x = 5;
        x += 1;
    }

    render() {
        return (
            <div>
                hello world
            </div>
        )
    }
}

class OutputTest extends React.Component{
    render() {

        return (
            <div>
                hello world
            </div>
        )
    }
}

ReactDOM.render(
    <App />,
    document.getElementById('react')
)