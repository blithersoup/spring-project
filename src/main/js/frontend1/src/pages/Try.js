import { Box, Spacer, Flex } from "@chakra-ui/react";
import PageHeader from './PageHeader'


function Feature() {
  return (
    <Flex direction="column" height="100vh">
      <PageHeader />
      <Spacer />
      <Box>Hello</Box>
      <Spacer />
    </Flex>
  );
}

export default Feature;