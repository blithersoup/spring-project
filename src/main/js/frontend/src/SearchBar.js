import { Input, Icon, Button} from "atomize";
import React from 'react';

function InputWithRightButton() {
    
    return (
      <Input
        placeholder="Search"
        suffix={
          <Button
            pos="absolute"
            onClick={() => console.log("clicked")}
            bg="info700"
            hoverBg="info800"
            w="3rem"
            top="0"
            right="0"
            rounded={{ r: "md" }}
          >
            <Icon
              name="Search"
              size="20px"
              color="white"
              cursor="pointer"
            />
          </Button>
        }
        onBlur={() => console.log(document.querySelector('Input').value)}
      />
    );
}


export default InputWithRightButton;
