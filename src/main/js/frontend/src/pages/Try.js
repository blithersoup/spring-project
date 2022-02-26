import { Box, Spacer, Flex } from "@chakra-ui/react";

function Feature({ title, desc, ...rest }) {
  return (
    <Flex direction="column" height="100vh">
      <Spacer />
      <Box>Hello</Box>
      <Spacer />
    </Flex>
  );
}

export default Feature;
