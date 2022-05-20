import { Flex, Box, Spacer } from "@chakra-ui/react";

export default function OldSearchBar() {
  return (
    <Flex direction="row" as="form">
      <Box
        as="input"
        placeholder="Enter search terms"
        flex="1"
        py={2}
        px={4}
        rounded="md"
        bg="gray.100"
        borderWidth="1px"
        ml="50"
        _hover={{ borderColor: "gray.200", bg: "gray.200" }}
        _focus={{
          outline: "none",
          bg: "white",
          boxShadow: "outline",
          borderColor: "gray.300",
        }}
      />
      <Box
        as="button"
        bg="blue.500"
        py={2}
        px={4}
        ml={3}
        rounded="md"
        fontWeight="semibold"
        color="white"
        _hover={{ bg: "blue.600" }}
        _focus={{ boxShadow: "outline" }}
      >
        Search
      </Box>
      <Spacer />
    </Flex>
  );
}
