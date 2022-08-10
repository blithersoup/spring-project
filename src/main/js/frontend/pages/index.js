import React from "react";
import { extendTheme, ChakraProvider, Flex, Spacer } from "@chakra-ui/react";
import PageHeader from "../components/PageHeader";
import SearchBar from "../components/SearchBar";

const colors = {
  brand: {
    900: "#1a365d",
    800: "#153e75",
    700: "#2a69ac",
  },
};
const theme = extendTheme({ colors });
export default function Home() {
  return (
    <ChakraProvider theme={theme}>
      <Flex direction="column" height="100vh">
        <PageHeader />
        <Spacer />
        <SearchBar />
        <Spacer />
      </Flex>
    </ChakraProvider>
  );
}
