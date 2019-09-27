#Region ;**** Directives created by AutoIt3Wrapper_GUI ****
#AutoIt3Wrapper_Icon=..\..\..\..\..\..\Desktop\enzo.ico
#EndRegion ;**** Directives created by AutoIt3Wrapper_GUI ****
#include <GUIConstantsEx.au3>
#include <StaticConstants.au3>
#include <WindowsConstants.au3>
#Include <NamedPipes.au3>

Local $hndlPipe
Local $aPipeData[4]
Local $imgPath1 = @ScriptDir & "\decrypting_1.jpg"
Local $imgPath2 = @ScriptDir & "\decrypting_2.jpg"
Local $imgPath3 = @ScriptDir & "\decrypting_3.jpg"

#Region ### START Koda GUI section ### Form=
$Decrypting = GUICreate("Decrypting...", 601, 301, 192, 124, 0)
$Pic = GUICtrlCreatePic($imgPath1, 0, 0, 600, 300)
GUISetState(@SW_SHOW)
#EndRegion ### END Koda GUI section ###

AdlibRegister(UpdateIt)

; Create the named pipe. Get data from the pipe until a "DIE" message is received.
;$hndlPipe = _NamedPipes_CreateNamedPipe("\\.\pipe\seminaire")

Func UpdateIt()

	$Pic = GUICtrlCreatePic($imgPath2, 0, 0, 600, 300)
	Sleep(1000)

	$Pic = GUICtrlCreatePic($imgPath3, 0, 0, 600, 300)
	Sleep(1000)

	$Pic = GUICtrlCreatePic($imgPath1, 0, 0, 600, 300)
	Sleep(1000)

EndFunc

UpdateIt()

;While 1
;	If $hndlPipe <> -1 Then
        ;Do
            ; wait for a client process to connect to an instance of a named pipe
;            If _NamedPipes_ConnectNamedPipe($hndlPipe) Then
;				AdlibUnRegister(UpdateIt)
;                $aPipeData = _NamedPipes_PeekNamedPipe($hndlPipe)
;                ConsoleWrite(@LF & "Pipe Server:: Data: """ & $aPipeData[0] & """" & ", " & $aPipeData[1] & ", " & $aPipeData[2] & ", " & $aPipeData[3] & @LF)
;
;					If $aPipeData[0] == "DIE" Then
;						Exit
;					EndIf
;
;                If Not _NamedPipes_DisconnectNamedPipe($hndlPipe) Then
;                    ConsoleWrite(@LF & "Pipe Server:: DisconnectNamedPipe() Failed." & @LF)
;                Endif
;            Else
;                ConsoleWrite(@LF & "Pipe Server:: connectNamedPipe() failed. " & @LF)
;                Exit
;            Endif
;        ;Until $aPipeData[0] == "DIE"
;    Else
;        ConsoleWrite(@LF & "Pipe Server:: _CreateNamedPipe() failed. " & @LF)
;    Endif
;WEnd

