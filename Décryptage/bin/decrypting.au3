#include <GUIConstantsEx.au3>
#include <StaticConstants.au3>
#include <WindowsConstants.au3>
#Include <NamedPipes.au3>

#Region ### START Koda GUI section ### Form=
$Decrypting = GUICreate("Decrypting...", 601, 301, 192, 124, 0)
$Pic = GUICtrlCreatePic("decrypting_1.jpg", 0, 0, 600, 300)
GUISetState(@SW_SHOW)
#EndRegion ### END Koda GUI section ###

Local $hndlPipe
Local $aPipeData[4]

; Create the named pipe. Get data from the pipe until a "DIE" message is received.
$hndlPipe = _NamedPipes_CreateNamedPipe("\\.\pipe\seminaire")

While 1
	Sleep(1000)
	$Pic = GUICtrlCreatePic("decrypting_2.jpg", 0, 0, 600, 300)

	Sleep(1000)
	$Pic = GUICtrlCreatePic("decrypting_3.jpg", 0, 0, 600, 300)

	Sleep(1000)
	$Pic = GUICtrlCreatePic("decrypting_1.jpg", 0, 0, 600, 300)

	Sleep(1000)
	$Pic = GUICtrlCreatePic("decrypting_2.jpg", 0, 0, 600, 300)

	Sleep(1000)
	$Pic = GUICtrlCreatePic("decrypting_3.jpg", 0, 0, 600, 300)

	Sleep(1000)
	$Pic = GUICtrlCreatePic("decrypting_1.jpg", 0, 0, 600, 300)

	If $hndlPipe <> -1 Then
        ;Do
            ; wait for a client process to connect to an instance of a named pipe
            If _NamedPipes_ConnectNamedPipe($hndlPipe) Then
                $aPipeData = _NamedPipes_PeekNamedPipe($hndlPipe)
                ConsoleWrite(@LF & "Pipe Server:: Data: """ & $aPipeData[0] & """" & ", " & $aPipeData[1] & ", " & $aPipeData[2] & ", " & $aPipeData[3] & @LF)

					If $aPipeData[0] == "DIE" Then
						Exit
					EndIf

                If Not _NamedPipes_DisconnectNamedPipe($hndlPipe) Then
                    ConsoleWrite(@LF & "Pipe Server:: DisconnectNamedPipe() Failed." & @LF)
                Endif
            Else
                ConsoleWrite(@LF & "Pipe Server:: connectNamedPipe() failed. " & @LF)
                Exit
            Endif
        ;Until $aPipeData[0] == "DIE"
    Else
        ConsoleWrite(@LF & "Pipe Server:: _CreateNamedPipe() failed. " & @LF)
    Endif
WEnd
