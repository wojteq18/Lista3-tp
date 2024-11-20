package eu.jpereira.trainings.designpatterns.structural.adapter.thirdparty;

import eu.jpereira.trainings.designpatterns.structural.adapter.exceptions.CodeMismatchException;
import eu.jpereira.trainings.designpatterns.structural.adapter.exceptions.IncorrectDoorCodeException;
import eu.jpereira.trainings.designpatterns.structural.adapter.model.Door;
import eu.jpereira.trainings.designpatterns.structural.adapter.thirdparty.ThirdPartyDoor.DoorState;
import eu.jpereira.trainings.designpatterns.structural.adapter.thirdparty.exceptions.CannotChangeCodeForUnlockedDoor;
import eu.jpereira.trainings.designpatterns.structural.adapter.thirdparty.exceptions.CannotChangeStateOfLockedDoor;
import eu.jpereira.trainings.designpatterns.structural.adapter.thirdparty.exceptions.CannotUnlockDoorException;

public class ThirdPartyDoorAdapter extends ThirdPartyDoor implements Door
{
    @Override
    public void open(String code) throws IncorrectDoorCodeException
    {
        try
        {
            this.unlock(code);
            this.setState(DoorState.OPEN);
        }
        catch (CannotUnlockDoorException e)
        {
            throw new IncorrectDoorCodeException();
        }
        catch (CannotChangeStateOfLockedDoor e)
        {
            throw new RuntimeException("Cannot open a locked door");
        }
    }

    @Override
    public void close()
    {
        try
        {
            this.setState(DoorState.CLOSED);
        }
        catch (CannotChangeStateOfLockedDoor e)
        {
            throw new RuntimeException("Cannot close a locked door");
        }
    }

    @Override
    public boolean isOpen()
    {
        return this.getState() == DoorState.OPEN;
    }

    @Override
    public void changeCode(String oldCode, String newCode, String newCodeConfirmation) throws IncorrectDoorCodeException, CodeMismatchException
    {
        try
        {
            this.unlock(oldCode);
            if (!newCode.equals(newCodeConfirmation))
            {
                throw new CodeMismatchException();
            }
            this.setNewLockCode(newCode);
            this.lock();
        }
        catch (CannotUnlockDoorException e)
        {
            throw new IncorrectDoorCodeException();
        }
        catch (CannotChangeCodeForUnlockedDoor e)
        {
            throw new RuntimeException("Cannot change code for an unlocked door");
        }
    }

    @Override
    public boolean testCode(String code)
    {
        try
        {
            this.unlock(code);
            this.lock();
            return true;
        }
        catch (CannotUnlockDoorException e)
        {
            return false;
        }    
    }
}