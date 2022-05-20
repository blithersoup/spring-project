import { Box, Spacer, Flex } from "@chakra-ui/react";
import Link from "next/link";

function PageHeader() {
  return (
    <Flex direction="row">
      <Spacer />
      <Box o="2">
        <Link href="/">
          <a>Twitter search</a>
        </Link>
      </Box>
      <Spacer />
      <Link href="/about">
        <a>About</a>
      </Link>
    </Flex>
  );
}

export default PageHeader;
