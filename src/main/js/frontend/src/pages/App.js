import "../App.css";
import { Flex, Spacer } from "@chakra-ui/react";
import PageHeader from "./PageHeader";
//import OldSearchBar from "./OldSearchBar";
import SearchBar from "./SearchBar";

function App() {
  return (
    <Flex direction="column" height="100vh">
      <PageHeader />
      <Spacer />
      <SearchBar />
      <Spacer />
    </Flex>
  );
}

export default App;
