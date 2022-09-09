import com.yuyan.model.Command;
import com.yuyan.repository.CommandHelper;
import com.yuyan.repository.CommandResolver;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class CommandUnitTest {

    public static void _main(String[] args) throws IOException {
        int max = 10;

        CommandHelper.init("seismic/test/res/A311D2_medium_auto_test_command.json");
        List<Command> commandList = CommandHelper.INSTANCE.commandList.commands;
        int sum = new Random().nextInt(max) + 1;
        String[] originCommands = new String[sum];
        String randomHexCode = RandomCommandFactory.createRandomCommands(commandList, sum, originCommands);
        String[] matchedCommands = CommandResolver.checkUnit(randomHexCode, commandList);
        List<String> checkA = RandomCommandFactory.toConfirm(matchedCommands, originCommands);
        List<String> checkB = RandomCommandFactory.toConfirm(originCommands, matchedCommands);

        System.out.println("randomHexCode = " + randomHexCode);
        System.out.println(Arrays.toString(matchedCommands));
        System.out.println(Arrays.toString(originCommands));
        System.out.println(checkA);
        System.out.println(checkB);
    }

    public static void main(String[] args) throws IOException {
        CommandHelper.init("seismic/test/res/A311D2_medium_auto_test_command.json");
        List<Command> commandList = CommandHelper.INSTANCE.commandList.commands;

        // String randomHexCode = "38393053713031300D383535536C3030300D";
        String randomHexCode = "38303147853030300D38303153603031300D";
        String[] matchedCommands = CommandResolver.checkUnit(randomHexCode, commandList);

        System.out.println("matchedCommands = " + Arrays.toString(matchedCommands));

    }
}