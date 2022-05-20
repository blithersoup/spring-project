import { Flex, Spacer } from "@chakra-ui/react";
import PageHeader from "../components/PageHeader";
import SearchBar from "../components/SearchBar";

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
