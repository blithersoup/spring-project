const React = require('react');
const ReactDOM = require('react-dom');
const client = require('./client');

class App extends React.Component {

    constructor(props) {
        super(props);
        this.state = {stuff: []}
    }

    componentDidMount() {

        client({method: 'GET', path: '/twitter/search'}).done(response => {
            this.setState({stuff: response})
        });
    }

    render() {
        return (
            <OutputTest ouput = OutputTest/>
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
// end::render[]