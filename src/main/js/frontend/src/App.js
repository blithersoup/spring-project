import './App.css';
import { Input, Icon, Button, Container, Text } from "atomize";
import SearchBar from './SearchBar';


function App() {
  return (
      <>
        <Container>
          <Text tag="h1" textSize="display1" m={{ b: "4rem" }}>
            Sample title
          </Text>
        </Container>
        <Container pos="fixed" top="50%">
            <SearchBar />
        </Container>
      </>
    
  );
}

export default App;
